package src;

public enum Naipe {
    PAUS {
        @Override
        public byte valor() {
            return 4;
        }
    },
    COPAS {
        @Override
        public byte valor() {
            return 3;
        }
    },
    ESPADAS {
        @Override
        public byte valor() {
            return 2;
        }
    },
    OUROS {
        @Override
        public byte valor() {
            return 1;
        }
    };

    public abstract byte valor();
}
