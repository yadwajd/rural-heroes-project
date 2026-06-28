/*!
* Start Bootstrap - Simple Sidebar v6.0.6 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
//
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

    // Section switching
    const navLinks = document.querySelectorAll('#sidebar-wrapper [data-section]');
    const sections = document.querySelectorAll('.content-section');
    const topbarTitle = document.getElementById('topbar-section-title');

    function showSection(sectionId) {
        sections.forEach(section => {
            section.classList.toggle('d-none', section.id !== sectionId);
        });

        navLinks.forEach(link => {
            link.classList.toggle('active', link.dataset.section === sectionId);
        });

        const activeSection = document.getElementById(sectionId);
        if (activeSection && topbarTitle) {
            topbarTitle.textContent = activeSection.dataset.title || '';
        }

        // Scroll content area back to top when switching sections
        window.scrollTo(0, 0);
    }

    navLinks.forEach(link => {
        link.addEventListener('click', event => {
            event.preventDefault();
            showSection(link.dataset.section);

            // Auto-collapse sidebar on small screens after a selection
            if (window.innerWidth < 768) {
                document.body.classList.remove('sb-sidenav-toggled');
            }
        });
    });

    // Citation links: switch to the References section, then jump to the anchor
    const citationLinks = document.querySelectorAll('.citation-link');
    citationLinks.forEach(link => {
        link.addEventListener('click', event => {
            event.preventDefault();
            showSection('references');

            const targetId = link.getAttribute('href').slice(1);
            const target = document.getElementById(targetId);
            if (target) {
                target.scrollIntoView({ block: 'start' });
            }
        });
    });

});
