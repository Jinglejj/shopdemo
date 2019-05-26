package entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuctionDO {

    private Integer id;

    private Integer categoryId;

    private String title;

    private String description;

    private String imageUrl;

    private double hisPrice;

    private double currentPrice;

    private int number;

    private int sellNumber;

    private String properties;

}
