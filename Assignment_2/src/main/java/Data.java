class Data {

    private final String no, name, fidelID, fed, rtg, club_or_city;

    public Data(String no, String name, String fidelID, String fed, String rtg, String club_or_city) {
        this.no = no;
        this.name = name;
        this.fidelID = fidelID;
        this.fed = fed;
        this.rtg = rtg;
        this.club_or_city = club_or_city;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getFidelID() {
        return fidelID;
    }

    public String getFed() {
        return fed;
    }

    public String getRtg() {
        return rtg;
    }

    public String getClub_or_city() {
        return club_or_city;
    }
}
