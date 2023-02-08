package parkinglot.factory;

import parkinglot.model.FeeModel;
import parkinglot.model.FeeModelStrategyFactory;

import static parkinglot.model.FeeModel.*;

public class FeeModelFactory {
    public FeeModelStrategyFactory getFeeModelStrategyFactory(FeeModel feeModel) {
        if(feeModel == MALL) {
            return new MallFeeStrategyFactory();
        } else if(feeModel == STADIUM){
            return new StadiumFeeStrategyFactory();
        } else if(feeModel == AIRPORT){
            return new AirportFeeStrategyFactory();
        } else {
            throw new IllegalArgumentException("Given Fee Model not supported");
        }
    }
}
