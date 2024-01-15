(function () {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    document.getElementById('sidebarToggle').addEventListener('click', function (e) {
        toggleSidebar();
    });

    document.getElementById('sidebarToggleTop').addEventListener('click', function (e) {
        toggleSidebar();
    });

    function toggleSidebar() {
        var body = document.body;
        var sidebar = document.querySelector(".sidebar");

        body.classList.toggle("sidebar-toggled");
        sidebar.classList.toggle("toggled");

        if (sidebar.classList.contains("toggled")) {
            var collapseElements = document.querySelectorAll('.sidebar .collapse');
            collapseElements.forEach(function (collapseElement) {
                collapseElement.collapse('hide');
            });
        }
    }

    // Close any open menu accordions when window is resized below 768px
    window.addEventListener('resize', function () {
        if (window.innerWidth < 768) {
            var collapseElements = document.querySelectorAll('.sidebar .collapse');
            collapseElements.forEach(function (collapseElement) {
                collapseElement.collapse('hide');
            });
        }

        // Toggle the side navigation when window is resized below 480px
        if (window.innerWidth < 480 && !document.querySelector(".sidebar").classList.contains("toggled")) {
            document.body.classList.add("sidebar-toggled");
            document.querySelector(".sidebar").classList.add("toggled");

            var collapseElements = document.querySelectorAll('.sidebar .collapse');
            collapseElements.forEach(function (collapseElement) {
                collapseElement.collapse('hide');
            });
        }
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    var sidebar = document.querySelector('body.fixed-nav .sidebar');

    if (sidebar) {
        sidebar.addEventListener('mousewheel', function (e) {
            handleMouseWheel(e);
        });

        sidebar.addEventListener('DOMMouseScroll', function (e) {
            handleMouseWheel(e);
        });

        sidebar.addEventListener('wheel', function (e) {
            handleMouseWheel(e);
        });
    }

    function handleMouseWheel(e) {
        if (window.innerWidth > 768) {
            var delta = e.wheelDelta || -e.detail;
            sidebar.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    }

// Scroll to top button appear
    document.addEventListener('scroll', function () {
        var scrollDistance = window.scrollY || document.documentElement.scrollTop;

        if (scrollDistance > 100) {
            document.querySelector('.scroll-to-top').style.display = 'block';
        } else {
            document.querySelector('.scroll-to-top').style.display = 'none';
        }
    });

// Smooth scrolling using JavaScript easing
    document.addEventListener('click', function (e) {
        if (e.target && e.target.classList.contains('scroll-to-top')) {
            e.preventDefault();
            var targetElement = document.querySelector(e.target.getAttribute('href'));
            if (targetElement) {
                scrollToTarget(targetElement);
            }
        }
    });

    function scrollToTarget(targetElement) {
        var targetPosition = targetElement.offsetTop;
        var startPosition = window.scrollY || document.documentElement.scrollTop;
        var distance = targetPosition - startPosition;
        var startTime = null;

        function animation(currentTime) {
            if (startTime === null) startTime = currentTime;
            var timeElapsed = currentTime - startTime;
            var run = easeInOutExpo(timeElapsed, startPosition, distance, 1000);
            window.scrollTo(0, run);
            if (timeElapsed < 1000) requestAnimationFrame(animation);
        }

        function easeInOutExpo(t, b, c, d) {
            t /= d / 2;
            if (t < 1) return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
            t--;
            return c / 2 * (-Math.pow(2, -10 * t) + 2) + b;
        }

        requestAnimationFrame(animation);
    }


})(); // End of use strict
