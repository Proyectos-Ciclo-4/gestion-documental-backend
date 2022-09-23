package docdoc.handle.model;

import java.util.Set;

public class CategoryModel {
    private String categoryId;
    private String categoryName;
    private Set<String> subcategories;
    private String userId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<String> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<String> subcategories) {
        this.subcategories = subcategories;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
