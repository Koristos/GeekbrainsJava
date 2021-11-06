public class Controller {
    private Model model;
    private View view;

    Controller (){
        this.model = new Model();
        this.view = new View();
    }

    public void setName(String name){
        this.model.setName(name);
        updateView();
    }

    public void setCategory(String category){
        this.model.setCategory(category);
        updateView();
    }

    public void setValue (Integer value){
        this.model.setValue(value);
        updateView();
    }

    private void updateView(){
        this.view.showView(model.getName(), model.getCategory(),model.getValue());
    }
}
