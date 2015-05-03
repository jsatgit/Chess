require.config({
    paths: {
        snap: 'vendors/snap',
        jquery: 'vendors/jquery',
        domReady: 'vendors/domReady'
    },
    shim: {
        'snap': {
            exports: 'snap'
        }
    }
});

require(['app']);
