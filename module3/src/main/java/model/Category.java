package model;

public class Category {
  private int id;
  private String nameCategory;

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    //    private String value;
//
//    Category(String value) {
//        this.value = value;
//    }
//
//
//    public String getValue() {
//        return this.value;
//    }
//
//    public static Category fromValue(String value) {
//        Category[] values = values();
//        for (Category category : values) {
//            if (category.value.equals(value))
//                return category;
//        }
//        throw new IllegalArgumentException("invalid");
//    }
}
