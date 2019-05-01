package dal.test;

import dal.dao.ProductDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Product;
import dal.dto.ProductBatch;
import dal.dto.interfaces.IProduct;
import dal.dao.interfaces.IProductDAO;
import dal.dto.interfaces.IProductBatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ProductDAOTest {


    IProductDAO productDAO = new ProductDAO();


    @Test
    public void productTest() throws IUserDAO.DALException {

        //Initialisation
        IProduct testProduct = new Product();
        testProduct.setProductID(1);
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
            productDAO.deleteProduct(1);
            boolean success = false;

            try{
                productDAO.getProduct(1);
            }catch (IUserDAO.DALException e){
                success = true;
            }
            assertTrue(success);

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }



    @Test
    public void productBatchTest() throws IUserDAO.DALException {

        //Initialisation
        IProductBatch testPBatch = new ProductBatch();
        testPBatch.setProductBatchID(6);
        testPBatch.setProductID(4);
        testPBatch.setQuantity(100);
        testPBatch.setRecipeID(88);
        testPBatch.setStatusID(5);

        try {
            //TEST of Create and Reed
            productDAO.createPBatch(testPBatch);
            IProductBatch recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductBatchID(), recivedPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductID(),recivedPBatch.getProductID());
            assertEquals(testPBatch.getQuantity(),recivedPBatch.getQuantity());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());
            assertEquals(testPBatch.getStatusID(),recivedPBatch.getStatusID());

            //Test of Update
            testPBatch.setQuantity(200);
            productDAO.updatePBatch(testPBatch);
            recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getQuantity(),recivedPBatch.getQuantity());

            productDAO.deletePBatch(testPBatch.getProductBatchID());
            boolean success = false;

            try{
                productDAO.getPBatch(testPBatch.getProductBatchID());
            }catch (IUserDAO.DALException e){
                success = true;
            }
            assertTrue(success);

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }










}
