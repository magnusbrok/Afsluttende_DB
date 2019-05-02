package dal.test;

import dal.dao.ProductDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Product;
import dal.dto.ProductBatch;
import dal.dto.interfaces.IProduct;
import dal.dao.interfaces.IProductDAO;
import dal.dto.interfaces.IProductBatch;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ProductDAOTest {


    IProductDAO productDAO = new ProductDAO();


    @Test
    public void productTest() {

        //Initialisation
        IProduct testProduct = new Product();
        testProduct.setProductID(300);
        testProduct.setProductName("Antibiotika");

        try {
            //TEST of Create and Reed
            productDAO.createProduct(testProduct);
            IProduct recivedProduct = productDAO.getProduct(testProduct.getProductID());
            assertEquals(testProduct.getProductID(),recivedProduct.getProductID());
            assertEquals(testProduct.getProductName(),recivedProduct.getProductName());

            //Test of Update
            testProduct.setProductName("Panodil");
            productDAO.updateProduct(testProduct);
            recivedProduct = productDAO.getProduct(testProduct.getProductID());
            assertEquals(testProduct.getProductName(),recivedProduct.getProductName());

            //Test of Delete
            productDAO.deleteProduct(testProduct.getProductID());
            assertEquals(0,productDAO.getProduct(testProduct.getProductID()).getProductID());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }



    @Test
    public void productBatchTest() {

        //Initialisation
        IProductBatch testPBatch = new ProductBatch();
        testPBatch.setProductBatchID(364);
        testPBatch.setProductID(1);
        testPBatch.setRecipeID(1);
        testPBatch.setStatusID(1);

        IProductBatch dbPBatch = new ProductBatch(); // Ligger allerede i databasen
        dbPBatch.setProductBatchID(1);
        dbPBatch.setProductID(1);
        dbPBatch.setRecipeID(1);
        dbPBatch.setStatusID(2);

        try {
            //TEST of Create and Reed
            productDAO.createPBatch(testPBatch);
            IProductBatch recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductBatchID(), recivedPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductID(),recivedPBatch.getProductID());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());
            assertEquals(testPBatch.getStatusID(),recivedPBatch.getStatusID());

            List<IProductBatch> batchList = productDAO.getPBatchList();
            boolean found = false;
            for(IProductBatch productBatch: batchList){
                if(productBatch.getProductBatchID() == testPBatch.getProductBatchID()){
                    assertEquals(testPBatch.getProductID(),productBatch.getProductID());
                    assertEquals(testPBatch.getRecipeID(),productBatch.getRecipeID());
                    assertEquals(testPBatch.getStatusID(),productBatch.getStatusID());
                    found = true;
                }else if (productBatch.getProductBatchID() == dbPBatch.getProductBatchID()) {
                    assertEquals(dbPBatch.getProductID(), productBatch.getProductID());
                    assertEquals(dbPBatch.getRecipeID(), productBatch.getRecipeID());
                    assertEquals(dbPBatch.getStatusID(), productBatch.getStatusID());
                    found = true;
                }
            }
            if(found = false){
                fail();
            }

            //Test of Update
            testPBatch.setRecipeID(2);
            productDAO.updatePBatch(testPBatch);
            recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());

            productDAO.deletePBatch(testPBatch.getProductBatchID());
            assertEquals(0,productDAO.getPBatch(testPBatch.getProductBatchID()).getProductBatchID());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }
}
