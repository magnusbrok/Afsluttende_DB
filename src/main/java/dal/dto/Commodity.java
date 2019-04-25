package dal.dto;

public class Commodity implements ICommodity {

    private int commodityID;
    private String commodityName;
    private boolean active;
    private boolean reorder;

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    @Override
    public String getCommodityName() {
        return commodityName;
    }

    @Override
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }


    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isReorder(){
        return reorder;
    }

    @Override
    public void setReorder(boolean reorder){
        this.reorder =reorder;
    }





}
