package com.ana.xworlds.entity;

import java.io.Serializable;

/**
 * Created by Ana on 2/18/2016.
 */
public class World implements Serializable {
    public String id;
    public String language;
    public String url;
    public String country;
    public WorldStatus worldStatus;
    public String mapURL;
    public String name;
}
