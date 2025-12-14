package model;

import java.util.List;

public class Pet {

    private long id;          // <-- petId yerine id
    private String name;      // <-- petName yerine name
    private String status;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;

    public Pet() {}

    public Pet(long id, String name, String status,
               Category category, List<String> photoUrls, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.category = category;
        this.photoUrls = photoUrls;
        this.tags = tags;
    }

    // Getters & Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }

    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }

    // Nested classes
    public static class Category {
        private int id;
        private String name;

        public Category() {}
        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static class Tag {
        private int id;
        private String name;

        public Tag() {}
        public Tag(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
