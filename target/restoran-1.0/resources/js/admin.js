$(document).ready(function () {

    $('.hide-menu_1').hide();
    $('.hide-menu_2').hide();
    $('.hide-menu_3').hide();
    $('.menu_1').on('click', function () {
        $('.hide-menu_1').toggle('slow');
    })
    $('.menu_2').on('click', function () {
        $('.hide-menu_2').toggle('slow');
    })
    $('.menu_3').on('click', function () {
        $('.hide-menu_3').toggle('slow');
    })
});