package hack.the.wap.musicinstrumentlessoner.model.dto;

public class NotificationDto {
    private boolean trueUser;
    private TemplateDto template;
    private UserDto user;
    private String name;
    private String main;
    private String date;

    public NotificationDto(boolean trueUser, TemplateDto template, UserDto user, String name, String main, String date) {
        this.trueUser = trueUser;
        this.template = template;
        this.user = user;
        this.name = name;
        this.main = main;
        this.date = date;
    }

    public boolean isTrueUser() {
        return trueUser;
    }

    public void setTrueUser(boolean trueUser) {
        this.trueUser = trueUser;
    }

    public TemplateDto getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDto template) {
        this.template = template;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
