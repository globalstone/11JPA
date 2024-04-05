package spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_prod_no")
    @SequenceGenerator(name = "seq_product_prod_no", sequenceName = "seq_product_prod_no", allocationSize = 1, initialValue = 10001)
    @Column(name = "prod_no")
    private Long prodNo;

    @Column(name = "prod_name", nullable = false, length = 100)
    private String prodName;

    @Column(name = "prod_detail", length = 200)
    private String prodDetail;

    @Column(name = "price")
    private Long price;

    @Column(name = "image_file", unique = true, length = 100)
    private String imageFile;

    @Column(name = "reg_date", columnDefinition = "DATE DEFAULT SYSDATE", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

}