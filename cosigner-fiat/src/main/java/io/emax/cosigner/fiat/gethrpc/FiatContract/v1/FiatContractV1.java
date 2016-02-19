package io.emax.cosigner.fiat.gethrpc.FiatContract.v1;

import io.emax.cosigner.fiat.gethrpc.FiatContract.FiatContractInterface;
import io.emax.cosigner.fiat.gethrpc.FiatContract.FiatContractParametersInterface;

public class FiatContractV1 implements FiatContractInterface {
  private static final String initData =
      "606060405260405161088638038061088683398101604052805160805160a051"
          + "9192019060006001819055601081905560058054600160a060020a0319168517"
          + "90555b82518110156100da578281815181101561000257906020019060200201"
          + "516007600050600083600101815260200190815260200160002060006101000a"
          + "815481600160a060020a03021916908302179055508060010160066000506000"
          + "858481518110156100025790602001906020020151600160a060020a03168152"
          + "60200190815260200160002060005081905550600101610042565b8251600460"
          + "0050819055508160006000508190555050505050610785806101016000396000" + "f3";

  private static final String contractPayload =
      "606060405236156100615760e060020a600035046312b58349811461006a5780"
          + "632f54bf6e1461008057806367fbd289146100a65780637e1f2bb8146100e657"
          + "8063a0e67e2b14610117578063f8b2cb4f146101a6578063fd764e68146101ca"
          + "575b6102d85b610002565b6010545b60408051918252519081900360200190f3"
          + "5b61006e600435600160a060020a038116600090815260066020526040812054"
          + "115b919050565b6102d8600435600554600160a060020a03166000908152600f"
          + "6020526040902054819010610065576040600020805482900390556010805482"
          + "9003905550565b6102d8600435600554600160a060020a03166000908152600f"
          + "60205260409020805482019055601080548201905550565b6040805160208181"
          + "01835260008083528351918201845280825260045493516102da949080591061"
          + "01455750595b90808252806020026020018201604052509150600090505b6004"
          + "548110156105be57600181016000908152600760205260409020548251600160"
          + "a060020a03919091169083908390811015610002576020908102909101015260"
          + "010161015d565b61006e600435600160a060020a0381166000908152600f6020"
          + "5260409020546100a1565b6102d8600480359060248035916044358083019290"
          + "8201359160643580830192908201359160843580830192908201359160a43580"
          + "830192908201359160c4359182019101356009805473ffffffffffffffffffff"
          + "ffffffffffffffffffff19168c1760a060020a60ff0219908116909155600580"
          + "549091169055600b89905560005b600b54811015610324578a8a828181101561"
          + "0002576000848152600c60209081526040909120805473ffffffffffffffffff"
          + "ffffffffffffffffffffff191692909102909301351790915550888882818110"
          + "1561000257905090906020020135600c60005060008381526020019081526020"
          + "016000206000506001016000508190555060010161024d565b005b6040518080"
          + "6020018281038252838181518152602001915080519060200190602002808383"
          + "829060006004602084601f0104600f02600301f1509050019250505060405180"
          + "910390f35b5060088c9055600d85905560005b600d548110156103e157868682"
          + "81811015610002576000848152600e60209081526040909120805460ff191692"
          + "9091029093013517909155508484828181101561000257905090906020020135"
          + "600e600050600083815260200190815260200160002060005060010160005081"
          + "9055508282828181101561000257905090906020020135600e60005060008381"
          + "5260200190815260200160002060005060020160005081905550600101610332"
          + "565b6104686000600a819055808080805b600b548410156105d057600a805460"
          + "00868152600c6020908152604091829020805460019190910154600854845195"
          + "8652600160a060020a03929092166c0100000000000000000000000002928501"
          + "9290925260348401919091526054830152519081900360740190209055600193"
          + "909301926103f0565b801561047d575060095460a060020a900460ff165b1561"
          + "05af575060085460015560005b600b548110156105af576000818152600c6020"
          + "908152604080832060010154600954600160a060020a03168452600f90925290"
          + "9120541061006557600c60005060008281526020019081526020016000206000"
          + "5060010160005054600f6000506000600960009054906101000a9004600160a0"
          + "60020a0316600160a060020a0316815260200190815260200160002060008282"
          + "8250540392505081905550600c60005060008281526020019081526020016000"
          + "2060005060010160005054600f6000506000600c600050600085815260200190"
          + "815260200160002060005060000160009054906101000a9004600160a060020a"
          + "0316600160a060020a0316815260200190815260200160002060008282825054"
          + "019250508190555060010161048c565b50505050505050505050505050565b50"
          + "919050565b600094505b5050505090565b600180546008549101146105e75760"
          + "0094506105c9565b60006002819055600381905593505b600d54841080156106"
          + "075750600884105b1561069257600a546000858152600e602090815260408083"
          + "20805460018281015460029390930154845197885260ff929092168786015286"
          + "8401929092526060860152905190936080818101949183900301908290866161"
          + "da5a03f1156100025750506040515192506106a683600160a060020a03811660"
          + "00908152600660205260409020546100a1565b600054600354106105c4576001"
          + "94506105c9565b91508160020a90506000821180156106c25750600254811660"
          + "00145b156106dd576002805482179055600380546001019055610779565b6009"
          + "54600160a060020a038481169116148015610704575060095460a060020a9004"
          + "60ff16155b1561072d576003805460010190556009805460a060020a60ff0219"
          + "1660a060020a179055610779565b600554600160a060020a0384811691161480"
          + "15610754575060055460a060020a900460ff16155b1561077957600380546001"
          + "0190556005805460a060020a60ff02191660a060020a1790555b600193909301" + "926105f656";

  /* Constructor: fiatcontract(address _admin, address[] _owners, uint _required) */

  /*  7e1f2bb8 createTokens(uint256) // Deposits in admin account for transfer to new owner.
      67fbd289 destroyTokens(uint256) // Destroys from the admin account.
      f8b2cb4f getBalance(address)
      a0e67e2b getOwners()
      12b58349 getTotalBalance()
      2f54bf6e isOwner(address)
      fd764e68 transfer(uint256 nonce, address sender, address[] to, uint256[] value,
                        uint8[] sigV, bytes32[] sigR, bytes32[] sigS) */

  private static final String createTokens = "7e1f2bb8";
  private static final String destroyTokens = "67fbd289";
  private static final String getBalance = "f8b2cb4f";
  private static final String getOwners = "a0e67e2b";
  private static final String getTotalBalance = "12b58349";
  private static final String isOwner = "2f54bf6e";
  private static final String transfer = "fd764e68";

  @Override
  public String getCreateTokens() {
    return createTokens;
  }

  @Override
  public String getDestroyTokens() {
    return destroyTokens;
  }

  @Override
  public String getGetBalance() {
    return getBalance;
  }

  @Override
  public String getGetOwners() {
    return getOwners;
  }

  @Override
  public String getGetTotalBalance() {
    return getTotalBalance;
  }

  @Override
  public String getIsOwner() {
    return isOwner;
  }

  @Override
  public String getTransfer() {
    return transfer;
  }

  @Override
  public String getInitData() {
    return initData;
  }

  @Override
  public String getContractPayload() {
    return contractPayload;
  }

  @Override
  public FiatContractParametersInterface getContractParameters() {
    return new FiatContractParametersV1();
  }
}
