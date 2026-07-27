package com.kafka.sub.model;

public record Course ( String id,String title, String trainer,Double price){};


//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTrainer() {
//        return trainer;
//    }
//
//    public void setTrainer(String trainer) {
//        this.trainer = trainer;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", trainer='" + trainer + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}
