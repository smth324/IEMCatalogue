package Catalogue;

public class IEM
{
    private String name;
    private String bass;
    private String mids;
    private String treble;
    private String review;
    private String build;
    private String category;
    private String inclusions;
    private String technicalities;
    private String overall;
    private double price;
    
    public IEM(final String name, final String bass, final String mids, final String treble, final String build, final String category, final String inclusions, final String technicalities, final String overall, final double price, final String review) {
        this.name = name;
        this.bass = bass;
        this.mids = mids;
        this.treble = treble;
        this.review = review;
        this.build = build;
        this.category = category;
        this.inclusions = inclusions;
        this.technicalities = technicalities;
        this.price = price;
        this.overall = overall;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBass() {
        return this.bass;
    }
    
    public String getMids() {
        return this.mids;
    }
    
    public String getTreble() {
        return this.treble;
    }
    
    public String getReview() {
        return this.review;
    }
    
    public String getBuild() {
        return this.build;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public String getTechnicalities() {
        return this.technicalities;
    }
    
    public String getInclusions() {
        return this.inclusions;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public String getOverall() {
        return this.overall;
    }
    
    @Override
    public String toString() {
        return this.overall;
    }
}