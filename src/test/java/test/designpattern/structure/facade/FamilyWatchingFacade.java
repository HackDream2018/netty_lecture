package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */
public class FamilyWatchingFacade {

    private Projects projects;
    private Screen screen;
    private Audio audio;
    private Popcorn popcorn;
    private Lights lights;

    public FamilyWatchingFacade() {
        this.projects = Projects.getInstance();
        this.screen = Screen.getInstance();
        this.audio = Audio.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.lights = Lights.getInstance();
    }

    // 细化操作
    public void ready() {
        lights.on();
        popcorn.on();
        screen.down();
        projects.on();
        projects.focus();
        audio.on();
        popcorn.takePopcorn();
        lights.dim();
    }

    public void end() {
        popcorn.off();
        lights.bright();
        audio.off();
        screen.up();
        projects.off();
        lights.off();
    }

}
