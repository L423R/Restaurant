/**
 * Created by Nguenchik on 15.10.2017.
 */
$(function () {
    var zalupoa = [];
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

    //kek

    $('.menu_drinks').on('click', function () {
        $(this).hide(),
            $(drinksHide).show()

    });
    $('.menu_drinks__back').on('click', function () {
        $(drinksHide).hide(),
            $('.menu_drinks').show()
    });

    //kek

    $('.menu_foods').on('click', function () {
        $(this).hide(),
            $(foodsHide).show()

    });
    $('.menu_foods__back').on('click', function () {
        $(foodsHide).hide(),
            $('.menu_foods').show()
    });


     $('.menu_hookah__water').on('click', function () {
         $('.spisok_zakazov__kek').append("<p>Кальян на воде</p>");
         zalupoa.push('Кальян на воде');
         alert(zalupoa);
     });
     $('.menu_hookah__milk').on('click', function () {
         $('.spisok_zakazov__kek').append("<p>Кальян на молоке</p> ");
     });
     $('menu_hookah__grape').on('click', function () {
         $('.spisok_zakazov__kek').append("<p>Кальян на грейпфруте</p>");
     });
    $('.oplata_ready').on('click' , function () {
        var money;
        money = prompt("Вы уверены? (да или нет)");
        if(money === 'да'){
            document.location.href = "stols.html";
        }else{
            return 5;
        }
    });

});

