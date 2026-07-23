var checkIfInstanceOf = function(obj, classFunction) {
    if (obj == null || typeof classFunction !== 'function') return false;


    if (typeof obj !== 'object' && typeof obj !== 'function') {
        return obj.constructor === classFunction || classFunction === Object;
    }

    let proto = Object.getPrototypeOf(obj);
    while (proto) {
        if (proto.constructor === classFunction) return true;
        proto = Object.getPrototypeOf(proto);
    }
    return false;
};
