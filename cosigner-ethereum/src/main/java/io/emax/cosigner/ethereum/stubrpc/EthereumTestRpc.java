package io.emax.heimdal.ethereum.stubrpc;

import java.math.BigInteger;

import io.emax.heimdal.ethereum.common.ByteUtilities;
import io.emax.heimdal.ethereum.common.DeterministicTools;
import io.emax.heimdal.ethereum.gethrpc.Block;
import io.emax.heimdal.ethereum.gethrpc.CallData;
import io.emax.heimdal.ethereum.gethrpc.EthereumRpc;
import io.emax.heimdal.ethereum.gethrpc.MultiSigContract;

public class EthereumTestRpc implements EthereumRpc {
  private static int txCounter = 1;

  @Override
  public String eth_getBalance(String address, String defaultBlock) {
    return "0x15AF1D78B58C40000";
  }

  @Override
  public String eth_getTransactionCount(String address, String defaultBlock) {
    return ByteUtilities.toHexString(
        ByteUtilities.stripLeadingNullBytes(BigInteger.valueOf(txCounter).toByteArray()));
  }

  @Override
  public String eth_getCode(String address, String defaultBlock) {
    return "0x" + MultiSigContract.getContractPayload();
  }

  @Override
  public String eth_getStorageAt(String address, String position, String defaultBlock) {
    return "0x5506c24faeb93b11b079814eadff7283368f287b";
  }

  @Override
  public String eth_sendRawTransaction(String transaction) {
    txCounter++;
    return DeterministicTools.hashSha3(transaction);
  }

  @Override
  public String eth_sign(String address, String data) {
    return "0x1234567890123456789012345678901234567890123456789012345678901234112345678901234567890123456789012345678901234567890123456789012341";
  }

  @Override
  public String eth_blockNumber() {
    return "0x05";
  }

  @Override
  public String eth_call(CallData object, String defaultBlock) {
    return null;
  }

  @Override
  public Block eth_getBlockByNumber(String number, boolean returnTxData) {
    return null;
  }
}