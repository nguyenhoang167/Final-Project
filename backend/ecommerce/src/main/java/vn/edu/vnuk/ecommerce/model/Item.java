package vn.edu.vnuk.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Price")
    private Float price;

    @NotNull
    @Column(name = "Amount")
    private Long amount;

    @Column(name = "PrimaryImageURL")
    private String primaryImageURL;

    @Column(name = "ImageURLs")
    private String imageURLs;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Transient
    private Float rating;

    @NotNull
    @Column(name = "CategoryId")
    private Long categoryId;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

    @Transient
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPrimaryImageURL() {
        return primaryImageURL;
    }

    public void setPrimaryImageURL(String primaryImageURL) {
        this.primaryImageURL = primaryImageURL;
    }

    public String getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(String imageURLs) {
        this.imageURLs = imageURLs;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", primaryImageURL='" + primaryImageURL + '\'' +
                ", imageURLs='" + imageURLs + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", rating=" + rating +
                ", categoryId=" + categoryId +
                ", updatedAt=" + updatedAt +
                ", category=" + category +
                '}';
    }
}
