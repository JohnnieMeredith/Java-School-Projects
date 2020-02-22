ppublic void priceRange(int exPrice)
{
    for (int i = 0; i < cars.length; i++){
        if(cars[i].getLowPrice() <= exPrice && exPrice <= cars[i].getHighPrice()){
            System.out.print(cars[i].getMake() + " " + cars[i].getModel());
        }
}