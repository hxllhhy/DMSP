package com.cah.cahdmsp.exception;

import com.cah.cahdmsp.result.CodeMsg;

public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = -2730435886134389441L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
