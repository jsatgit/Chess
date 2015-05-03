require.config({
    paths: {
        snap: 'vendors/snap',
        jquery: 'vendors/jquery'
    },
    shim: {
        'snap': {
            exports: 'snap'
        }
    }
});

require(['app']);
