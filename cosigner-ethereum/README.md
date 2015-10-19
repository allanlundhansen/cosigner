# heimdal-ethereum

### Ownership & License

## Overview

An ethereum implementation for heimdal-api  

## Current State

Unstable
- Multi-sig/contracts still need to be implemented
- Monitor is not implemented

# Warning #
heimdal-ethereum tracks addresses based on the contract creation account and the specific contract it uses. Until the contract is finalized, any software updates may break heimdal's ability to access accounts from previous versions. So you should only be using this on a test network. We will attempt to address the changing contracts issue once the library is stable.

## Testing recommendations

You'll need an ethereum network. Create a local/private copy for testing with no peers. Delete the data directory to reset the network.

For now, create the following genesis block file as private_genesis.json and load it:
```json
{
    "nonce": "0xdeadbeefdeadbeef",
    "timestamp": "0x0", 
    "parentHash": "0x0000000000000000000000000000000000000000000000000000000000000000", 
    "extraData": "0x686f727365", 
    "gasLimit": "0x8000000", 
    "difficulty": "0x400", 
    "mixhash": "0x0000000000000000000000000000000000000000000000000000000000000000", 
    "coinbase": "0x3333333333333333333333333333333333333333",
    "alloc": {
   }
}
```

```bash
geth --datadir="D:\ETHTest" --verbosity "6" --maxpeers "0" --port 30301 --rpc --rpcport 8101 --genesis ./private_genesis.json console
```

Coin creation is done through mining. In another window create a base account
```bash
geth --datadir="D:\ETHTest" --port 30301 --rpcport 8101 account new
```

If you want a second console to make it easier to see data use:
```bash
geth --datadir="D:\ETHTest" --maxpeers "0" --port 30301 --rpcport 8101 attach
```

If you get errors when you try to mine about no coinbase, set the --etherbase on your geth console command and pass it the public address where your mining proceeds should go. This should just work though if you use the command above to create a new account. 

In order to start mining in the console run: 
```js
miner.start(#threads)
```
And to stop:
```bash
miner.stop()
```

Recommend that you use at most [# cpu's - 1] to avoid a slow/non-responsive console. And for a private network 1 is probably sufficient, difficulty is not high. You do need to be mining to confirm tx's when testing.

Once that's working, run the JAR directly and it will provide you with command line access to the interface. 
```bash
java -jar heimdal-ethereum-0.0.1-SNAPSHOT.jar getNewAddress <random hex string without leading 0x>
```

Check the account balance (before and after your transaction above)
```bash
java -jar heimdal-ethereum-0.0.1-SNAPSHOT.jar getBalance <address>
```

Creating a transaction is fairly straightforward. The sender value can be whatever, ethereum doesn't use it. We may use it as extraData at some point.
```bash
java -jar heimdal-ethereum-0.0.1-SNAPSHOT.jar createTransaction <from> <to> <amount in Ether>
```

Sign it as appropriate. If the key is stored in geth, don't pass in the hex string for the account. If it's a deterministic account, enter the account string and heimdal will figure out which key to use.
```bash
java -jar heimdal-ethereum-0.0.1-SNAPSHOT.jar signTransaction <tx string> <signer> <optional account hex>
```

And finally
```bash
java -jar heimdal-ethereum-0.0.1-SNAPSHOT.jar sendTransaction <signed tx string>
```

### Multi-sig test

Works exactly like heimdal-bitcoin's multi-sig now. Only difference is that we don't care about signature order, order only affects who pays gas fees.

Create the multi-sig address. The configuration has a "contract" address, this is the address that will pay for the contract creation. Make sure it's unlocked and funded so we can create it.
Wait 1-2 confirmations on the test-net, listing addresses through heimdal should now show the address. If reloaded it should still show them, it does this by scanning the contract account's transactions for our contract code.

Create a transaction from the multisig account and sign it using the multi-sig address and user key. 
Sign it using the multi-sig address and no user key to sign it with any unlocked wallet/geth keys that heimdal knows about.
Send the transaction. 
The last account to sign it pays the gas fees, so it's recommended that you sign it with a common account last that you keep funded. 

Due to the overhead involved in moving arrays around we opted for a fixed size of signers/owners to keep gas down. It's set to more than we should need for a 2-of-3 setup.

### Notes