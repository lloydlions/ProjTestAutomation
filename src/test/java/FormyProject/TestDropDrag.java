package FormyProject;

import org.testng.annotations.Test;
import pageobject.AlertTabsPage;
import pageobject.DragAndDropPage;

public class TestDropDrag {
    DragAndDropPage dragAndDrop;

    @Test
    public void testAlertTabsPage(){
        dragAndDrop = new DragAndDropPage();
        dragAndDrop.navigateToPage();
        dragAndDrop.dragImageToLocation();
    }
}
