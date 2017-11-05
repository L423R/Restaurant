
/**
 * Created by Nguenchik on 15.10.2017.
 */
$(window).on('load', function(){
    var hookaHide = (".menu_hookah__hide");
    var drinksHide = (".menu_drinks__hide");
    var foodsHide = (".menu_foods__hide");


    $(hookaHide).hide();
    $(drinksHide).hide();
    $(foodsHide).hide();

    $('.menu_hookah').on('click', function () {
        $(this).hide(),
            $(hookaHide).show()

    });
    $('.menu_hookah__back').on('click', function () {
        $(hookaHide).hide(),
            $('.menu_hookah').show()
    });


    $('.menu_drinks').on('click', function () {
        $(this).hide(),
            $(drinksHide).show()

    });
    $('.menu_drinks__back').on('click', function () {
        $(drinksHide).hide(),
            $('.menu_drinks').show()
    });


    $('.menu_foods').on('click', function () {
        $(this).hide(),
            $(foodsHide).show()

    });
    $('.menu_foods__back').on('click', function () {
        $(foodsHide).hide(),
            $('.menu_foods').show()
    });

});

