package dal.dto.interfaces;

public interface ICommodity {

    int getCommodityID();
    void setCommodityID(int CommodityID);

    String getCommodityName();
    void setCommodityName(String CommodityName);

    boolean isActive();
    void setActive(boolean active);

    boolean isReorder();
    void setReorder(boolean reorder);

}
