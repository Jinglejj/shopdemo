package entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CartDO {

	private AuctionDO auctionDO;

	private int number;

	private double totalPrice;

}
