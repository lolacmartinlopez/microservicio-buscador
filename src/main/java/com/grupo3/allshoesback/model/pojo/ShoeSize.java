package com.grupo3.allshoesback.model.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shoe_sizes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ShoeSize{
	
	@EmbeddedId
	private ShoeSizeKey id;
	
	@ManyToOne
    @MapsId("shoeId")
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;

	@ManyToOne
    @MapsId("sizeId")
    @JoinColumn(name = "size_id")
	private Size size;
	
	@Column(name = "stock")
	private Integer stock;
}
