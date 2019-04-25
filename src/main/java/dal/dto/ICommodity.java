package dal.dto;

import java.util.List;

public interface ICommodity {






int getCommodityID();
void setCommodityID(int CommodityID);

String getCommodityName();
void setCommodityName(String CommodityName);

boolean isActive();
boolean setActive(boolean active);

boolean isReorder();
boolean setReorder(boolean reorder);


}
