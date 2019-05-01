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
        IProduct testProduct = new Product();
        testProduct.setProductID(1);
        testProduct.setProductName("Antibiotika");
        try {
            //TEST of Create and Reed
            productDAO.createProduct(testProduct);
            IProduct recivedProduct = productDAO.getProduct(1);
            assertEquals(testProduct.getProductID(),recivedProduct.getProductID());
            assertEquals(testProduct.getProductName(),recivedProduct.getProductName());

            //Test of Update
            testProduct.setProductName("Panodil");
            productDAO.updateProduct(testProduct);
            recivedProduct = productDAO.getProduct(1);
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
        IProductBatch testPBatch = new ProductBatch();

        testPBatch.setProductBatchID(14);
        testPBatch.setProductID(3);
        testPBatch.setQuantity(100);
        testPBatch.setRecipeID(7);
        testPBatch.setStatusID(2);


        try {
            productDAO.createPBatch(testPBatch);
            IProductBatch recivedPBatch = productDAO.getPBatch(14);
            assertEquals(testPBatch.getProductBatchID(), recivedPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductID(),recivedPBatch.getProductID());
            assertEquals(testPBatch.getQuantity(),recivedPBatch.getQuantity());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());
            assertEquals(testPBatch.getStatusID(),recivedPBatch.getStatusID());


            testPBatch.setQuantity(200);
            productDAO.updatePBatch(testPBatch);
            recivedPBatch = productDAO.getPBatch(14);
            assertEquals(testPBatch.getQuantity(),recivedPBatch.getQuantity());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }










}
