package dal.dto;

public interface IProductBatch {

    //ikke færdig, døjer med nogle overvejelser omkring relevante attributter... - siff

    int productBatchID;
    int productID;
    int recipeID;
    int statusID;

    int getProductBatchID();

    void setProductBatchID(int productBatchID);

    int getProductID();

    void setProductID(int productID);

    int getRecipeID();

    void setRecipeID(int recipeID);

    int getStatusID();

    void setStatusID(int statusID);

}
