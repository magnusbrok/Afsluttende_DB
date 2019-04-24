package dal.dao;

import dal.dto.*;

import java.util.List;

public interface IProductDAO {

    //Create
    void createProduct(IProduct product);
    void createPBatch(IProductBatch productBatch);

    //Reed
    IProduct getProduct(int productID);
    IProductBatch getPBatch(int productBatchID);
    List<IProduct> getProductList();
    List<IProductBatch> getPBatchList();
    List<IProductBatch> getPBatchList(IProduct product);
    List<IProductBatch> getPBatchList(IRecipe recipe);
    List<IProductBatch> getPBatchList(int statusID);

    //Update
    void updateProduct(IProduct product);
    void updatePBatch(IProductBatch productBatch);

    //Delete - giver det egenligt mening at have disse delete metoder i forhold til logik og database desing? - siff
    void deleteProduct(int productID);
    void deletePBatch(int productBatchID);
}
