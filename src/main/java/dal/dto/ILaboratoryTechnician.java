package dal.dto;

public interface ILaboratoryTechnician extends IUser{


    public int getPb_ID();
    public void setPb_ID();


    public int getRe_ID();
    public void setRe_ID();

    public int getQuantity();
    public void setQuantity_ID();






    //should retrieve productBatch from DB, and assign private values with get/setters.
    void getProductBatch(int pb_ID);

    // should retrieve all ingredients and store the information in an ingredient object???????????
    void getIngredients();


    // should remove the actually used amount of a certain ingredient, from its respective commodityBatch;
    void updateBatch(int actualAmount, int c_ID);


    // Inserts information regarding the pBatch, cBatch and c_ID, that has been used.
    void insertIntoCbExtract();

}
