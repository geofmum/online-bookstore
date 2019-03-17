$(() => {
    class BookDetailsModule {
        constructor() {
            // holds a cache of dom elements
            this.$cache = {
                // buttons
                addToCartBtn: null,
                buyItNowBtn: null,

                // inputs
                deliveryRadio: null,

                // misc
                priceList: null,

                price: {
                    quoted: null,
                    discounted: null,
                    percentage: null
                },
                quotedPrice: null
            };

            this.packageTypePriceIndexes = {
                hardcover: 1,
                audiobook: 0.9,
                largeprint: 3
            };

            this.cartItem = {
                packageType: 'hardcover'
            };

            this.loadElements(this.$cache);
            this.registerDomEvents(this.$cache);
            this.computePricelistPrices();
            this.computeQuotedPrice("hardcover");

        }

        loadElements(cache) {
            cache.addToCartBtn = $('#add-to-cart');
            cache.buyItNowBtn = $('#buy-it-now');
            cache.deliveryRadio = $('input[name="delivery"]');

            cache.price.quoted = $('#price-quoted');
            cache.price.discounted = $('#discount-amount');
            cache.price.percentage = $('#percent-value');
            cache.priceList = $('#price-list');
        }

        registerDomEvents(cache) {
            const that = this;
            cache.addToCartBtn.click(() => this.onAddToCart());
            cache.buyItNowBtn.click(() => this.onBuyItNow());

            cache.priceList.children('.price-option').each(function () {
                const $el = $(this);
                $el.click(() => that.onSelectPackageType($el));
            });
        }

        onAddToCart() {
            this.cartItem.packageType = this.$cache.priceList.children('.selected').first().data().package;

            console.log(this.cartItem);
            console.log($('input[name="delivery"]:checked').val());
            // const cartItem = {
            //     bookPackage:
            // }
        }

        onBuyItNow() {
            console.debug('buy item now');
        }

        onSelectPackageType($el) {
            const packageType = $el.data().package;

            $el.siblings('.selected')
                .removeClass('selected');
            $el.addClass("selected");

            this.computeQuotedPrice(packageType);
        }

        computeQuotedPrice(packageType) {
            const {quotedPrice} = this.$cache.price.quoted.data();
            const pricingIndex = this.packageTypePriceIndexes[packageType];
            const price = pricingIndex * quotedPrice;
            const discountedAmount = price * this.$cache.price.percentage.data().discount;

            this.$cache.price.quoted.text(this.round(price, 2));
            this.$cache.price.discounted.text(this.round(discountedAmount, 2));
        }

        computePricelistPrices() {
            const that = this;
            this.$cache.priceList.children('.price-option').each(function () {
                const $el = $(this);
                const packageType = $el.data().package;

                const {quotedPrice} = that.$cache.price.quoted.data();
                const pricingIndex = that.packageTypePriceIndexes[packageType];
                const price = pricingIndex * quotedPrice;

                $el.find(".price-value").first().text(price);
            });
        }

        round(value, decimals) {
            return Number(Math.round(value + 'e' + decimals) + 'e-' + decimals);
        }
    }

    new BookDetailsModule();
});