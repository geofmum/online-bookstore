(function () {
    class ShoppingCartPage {
        constructor() {
            this.$dom = {
                checkoutBtn: null
            };

            this.cacheDomElements();
            this.registerEvents();
        }

        cacheDomElements() {
            this.$dom.checkoutBtn = $('#checkout');
        }

        registerEvents() {
            this.$dom.checkoutBtn.click(() => {
                $.ajax('/cart', {
                    method: 'PUT'
                }).done(() => {
                    location.href = "/";
                });

                return false;
            });
        }
    }

    $(() => new ShoppingCartPage());
})();