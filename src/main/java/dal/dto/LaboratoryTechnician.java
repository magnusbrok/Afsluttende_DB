package dal.dto;

import java.util.List;

public class LaboratoryTechnician extends User implements ILaboratoryTechnician  {


    private int Pb_ID;
    private int Re_ID;
    private int Quantity;


    @Override
    public int getPb_ID() {
        return Pb_ID;
    }

    @Override
    public void setPb_ID() {
    }

    @Override
    public int getRe_ID() {
        return Re_ID;
    }

    @Override
    public void setRe_ID() {

    }

    @Override
    public int getQuantity() {
        return Quantity;
    }

    @Override
    public void setQuantity_ID() {

    }

    @Override
    public void getIngredients() {

    }

    @Override
    public void getProductBatch(int pb_ID) {

    }
    
    @Override
    public void updateBatch(int actualAmount, int c_ID) {

    }

    @Override
    public void insertIntoCbExtract() {

    }
}
