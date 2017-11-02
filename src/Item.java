public class Item {

    // instance variables
    private String _name;
    private Image _image;

    /**
     * Constructor that specifies the name and image.
     * @param name the name that the instance variable _name will be set to.
     * @param image the image that the instance variable _image will be set to.
     */
    Item(String name, Image image){
        this._name = name;
        this._image = image;
    }

    /**
     * Returns the value of the instance variable _name.
     * @return _name instance variable.
     */
    public String getName() {
        return _name;
    }

    /**
     * Returns a boolean depending on if the object passed has the same name as the Item.
     * @param o an object that is required to be a Person, Pet, Possession, or Moment.
     * @return a boolean showing if the names of the objects are equal.
     */
    public boolean equals(Object o){
        if(_name.equals(((Item) o)._name)){
            return true;
        } 
        else {
            return false;
        }
    }

}