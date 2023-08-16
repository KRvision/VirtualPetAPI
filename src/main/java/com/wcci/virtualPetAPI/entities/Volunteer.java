package com.wcci.virtualPetAPI.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "\"volunteer\"")
@Transactional
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Volunteer_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "volunteer_shelter_id", joinColumns = @JoinColumn(name = "volunteer_id"), inverseJoinColumns = @JoinColumn(name = "shelter_id"))
    private List<VirtualPetShelter> shelters = new ArrayList<>();

    public Volunteer() {

    }

    public Volunteer(long id, String name, int age, String email, List<VirtualPetShelter> shelters) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.shelters = shelters;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VirtualPetShelter> getShelters() {
        return shelters;
    }

    public void setShelters(List<VirtualPetShelter> shelters) {
        this.shelters = shelters;
    }

}
