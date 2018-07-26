package hack.the.wap.musicinstrumentlessoner.model.dto;

public class TemplateDto {
    private UserDto Owner;
    private String MusicTitle;
    private String Musician;
    private String Main;
    private String Sub;

    /**
     * Create Template
     * @param owner
     * @param musicTitle
     * @param musician
     * @param main
     * @param sub
     */
    public TemplateDto(UserDto owner, String musicTitle, String musician, String main, String sub) {
        Owner = owner;
        MusicTitle = musicTitle;
        Musician = musician;
        Main = main;
        Sub = sub;
    }

    public UserDto getOwner() {
        return Owner;
    }

    public void setOwner(UserDto owner) {
        Owner = owner;
    }

    public String getMusicTitle() {
        return MusicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        MusicTitle = musicTitle;
    }

    public String getMusician() {
        return Musician;
    }

    public void setMusician(String musician) {
        Musician = musician;
    }

    public String getMain() {
        return Main;
    }

    public void setMain(String main) {
        Main = main;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }
}
