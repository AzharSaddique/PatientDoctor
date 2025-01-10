package  com.mtbc.mvvmwithflow.slidingNav.slidingrootnav.callback;


public interface DragStateListener {

    void onDragStart();

    void onDragEnd(boolean isMenuOpened);
}
