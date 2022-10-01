package com.sofka.docdoc;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.events.CategoryCreated;
import com.sofka.docdoc.events.SubCategoryCreated;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.CategoryName;
import com.sofka.docdoc.values.SubCategory;
import com.sofka.docdoc.values.UserId;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryDoc extends AggregateEvent<CategoryId> {
    protected CategoryName categoryName;
    protected Instant dateCreated;

    protected UserId userId;
    protected Set<SubCategory> subCategory;

    public CategoryDoc(UserId userId, CategoryId categoryId, CategoryName categoryName) {
        super(categoryId);
        this.categoryName = categoryName;
        this.dateCreated = Instant.now();
        this.subCategory = new HashSet<>();
        subscribe(new CategoriaDocChange(this));
        appendChange(new CategoryCreated(userId, categoryId, categoryName)).apply();
    }

    public CategoryDoc(CategoryId entityId) {
        super(entityId);
        subscribe(new CategoriaDocChange(this));
    }
    public static CategoryDoc from(CategoryId entityId, List<DomainEvent> events) {
        var category = new CategoryDoc(entityId);
        events.forEach(category::applyEvent);
        return category;
    }
    public void addSubCategory(SubCategory subcategory) {
        appendChange(new SubCategoryCreated(subcategory)).apply();
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Set<SubCategory> getSubCategory() {
        return subCategory;
    }

}
