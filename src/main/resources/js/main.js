/*  ---------------------------------------------------
    Template Name: Megapod
    Description: Mogapod Music Tamplate
    Author: Colorib
    Author URI: https://www.colorib.com/
    Version: 1.0
    Created: Colorib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Podcast filter
        --------------------*/
        $('.filter__controls li').on('click', function () {
            $('.filter__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.podcast-filter').length > 0) {
            var containerEl = document.querySelector('.podcast-filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        var $this = $(this);
        
        // Set background image
        $this.css({
            'background-image': 'url(' + bg + ')',
            'background-position': 'center center',
            'background-repeat': 'no-repeat',
            'background-attachment': 'scroll'
        });
        
        // Responsive background size
        function setBackgroundSize() {
            var windowWidth = $(window).width();
            var windowHeight = $(window).height();
            
            if (windowWidth <= 480) {
                // Mobile - use contain to show full image
                $this.css('background-size', 'contain');
            } else if (windowWidth <= 768) {
                // Tablet - use cover but adjust positionз
                $this.css('background-size', 'cover');
                $this.css('background-position', 'center top');
            } else {
                // Desktop - use cover
                $this.css('background-size', 'cover');
                $this.css('background-position', 'center center');
            }
        }
        
        // Set initial size
        setBackgroundSize();
        
        // Update on window resize
        $(window).on('resize', setBackgroundSize);
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    //Canvas Menu
    $(".canvas__open").on('click', function () {
        $(".offcanvas-menu-wrapper").addClass("active");
        $(".offcanvas-menu-overlay").addClass("active");
    });

    $(".offcanvas-menu-overlay").on('click', function () {
        $(".offcanvas-menu-wrapper").removeClass("active");
        $(".offcanvas-menu-overlay").removeClass("active");
    });

    /*------------------
		Magnific
	--------------------*/
    $('.video-popup').magnificPopup({
        type: 'iframe'
    });

})(jQuery);