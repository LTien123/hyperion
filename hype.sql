-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 13, 2024 lúc 11:54 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `hype`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blogs`
--

CREATE TABLE `blogs` (
  `id` bigint(20) NOT NULL,
  `carousel_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `sub_title` text DEFAULT NULL,
  `thumbnail_public_id` varchar(255) DEFAULT NULL,
  `image-url` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `blog_category_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `blogs`
--

INSERT INTO `blogs` (`id`, `carousel_at`, `created_at`, `description`, `is_active`, `sub_title`, `thumbnail_public_id`, `image-url`, `title`, `updated_at`, `blog_category_id`, `user_id`) VALUES
(1, '2024-11-13 11:15:22.000000', '2024-11-13 10:54:11.000000', '<p><img class=\"page-hero__desktop-img desktop-only\" src=\"https://cdn.bfldr.com/XM1XF37H/at/3x6hxm438cfs87jwwfjtkmxh/Manchester_MY23_24.jpg?auto=webp&amp;width=1200&amp;height=900&amp;format=jpg\" alt=\"why brompton\" width=\"1000\" data-v-f28e6efe=\"\"></p>\r\n<h1 class=\"page-hero__title\" data-v-f28e6efe=\"\"><span style=\"color: #e03e2d;\">Compact. Portable. Super fun.</span></h1>\r\n<p><span style=\"color: #e03e2d;\"><span style=\"color: #e03e2d;\">Few bikes can claim to be as recognisable as the hyperion. It looks different. It is different.<br>It\'s a useful tool that makes owners smile. The magic of the fold. The space and time saved. Freedom every day.&nbsp;</span></span></p>\r\n<h2 class=\"page-hero__title\" data-v-f28e6efe=\"\">Nothing folds like a hyperion folds</h2>\r\n<p>Invented by our founder Andrew Ritchie in 1975, the hyperion 3-part fold transforms the bike into a small locked package in under 20-seconds. Never bettered, just refined. It&rsquo;s the original and still the best.</p>\r\n<p><img class=\"page-hero__desktop-img desktop-only\" src=\"https://cdn.bfldr.com/XM1XF37H/at/h55vq6jg8h5wr6trpwk42m/Why_Brompton_3_1920x805.jpg?width=1920&amp;height=805&amp;format=jpg\" alt=\"why brompton\" width=\"1000\" data-v-f28e6efe=\"\"></p>', b'1', 'Few bikes can claim to be as recognisable as the Brompton. It looks different. It is different. It\'s a useful tool that makes owners smile. The magic of the fold. The space and time saved. Freedom every day. ', 'zpuoxiqra2bhf9nqsipw', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731470051/zpuoxiqra2bhf9nqsipw.jpg', 'Who are we', '2024-11-13 11:16:14.000000', 1, 1),
(2, '2024-11-13 11:26:15.000000', '2024-11-13 11:26:03.000000', '<p><img class=\"page-hero__desktop-img desktop-only\" src=\"https://cdn.bfldr.com/XM1XF37H/at/ptxvxtcv5bzr77f8js7xr/Barbour_Brompton_HIGH_RES_2.jpg?auto=webp&amp;width=2880&amp;height=1920&amp;format=jpg\" alt=\"careers\" width=\"1000\" data-v-f28e6efe=\"\"></p>\r\n<h1 class=\"page-hero__title\" data-v-f28e6efe=\"\">We create urban freedom for happier lives</h1>\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\">Unfold your next career opportunity</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">We are on a mission to transform urban living. We are looking for talented and passionate people who want to make a difference. If you want to be part of the solution, find out how you can contribute.​</div>\r\n<div class=\"checkerboard__cta-wrapper\" data-v-1277f382=\"\"><a class=\"br-link checkerboard__cta-button button\" href=\"https://brompton.wd3.myworkdayjobs.com/Brompton\" data-v-1277f382=\"\" aria-label=\"Our open positions\">Our open positions</a></div>\r\n<p>&nbsp;</p>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\"><a class=\"br-link checkerboard__cta-button button\" href=\"https://brompton.wd3.myworkdayjobs.com/Brompton\" data-v-1277f382=\"\" aria-label=\"Our open positions\"><img class=\"checkerboard__image\" style=\"float: right;\" src=\"https://cdn.bfldr.com/XM1XF37H/at/r7g6bwkkxw85367gzbvcvxr/Brompton_CHPT3_0492_HiRes.jpg?auto=webp\" alt=\"careers\" width=\"474\" height=\"316\" loading=\"lazy\" data-v-1277f382=\"\"></a></div>\r\n<p>&nbsp;</p>\r\n<div class=\"checkerboard__cta-wrapper\" style=\"text-align: left;\" data-v-1277f382=\"\"><a class=\"br-link checkerboard__cta-button button\" href=\"https://brompton.wd3.myworkdayjobs.com/Brompton\" data-v-1277f382=\"\" aria-label=\"Our open positions\">\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\"><em><span style=\"color: #000000;\">Diversity and inclusion</span></em></h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\"><em><span style=\"color: #000000;\">We are an Equal Opportunity Employer and strive to build a diverse and inclusive workforce at our company. At Brompton we aspire to engage with diverse individuals, communities, and organisations in order to continue to nurture a rich diverse culture.</span></em></div>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">&nbsp;</div>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">&nbsp;</div>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">&nbsp;</div>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">&nbsp;</div>\r\n</a></div>', b'1', 'oin our teams and bring your true self to work', 'vkpj7wzclkltfvzrg0ch', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731471969/vkpj7wzclkltfvzrg0ch.webp', 'Work with Hyperion', NULL, 1, 1),
(3, NULL, '2024-11-13 11:32:01.000000', '<h1 class=\"plp-banner__title desktop-only\" data-v-6042133f=\"\">Website Terms of Use and Sale</h1>\r\n<h2>Introduction</h2>\r\n<p>These terms and conditions (&lsquo;<strong>Terms</strong>&rsquo;) set out the terms and conditions on which you may access and use the hyperion website at www.hyperion.com (the &lsquo;<strong>Website</strong>&rsquo;), and (if applicable) purchase any products via the Website.</p>\r\n<p>Please read these Terms carefully before using any aspect of the Website as, by accessing or using the Website and (if applicable) by purchasing any products via the Website, you indicate that you accept these Terms and agree to abide by them. If you do not agree to these Terms, you must not use or access the Website.</p>\r\n<p>These terms and conditions were last updated in August 2023.</p>\r\n<p>We will process any personal data provided to us in line with our&nbsp;<u><a href=\"https://www.brompton.com/legal/privacy-policy\" data-type=\"internal\">privacy policy</a></u>.</p>\r\n<p>The Website is owned and operated by&nbsp;<strong>hyperion Bicycle Retail Limited</strong>, a company registered in England and Wales under company number 14658134 with registered address at Unit 1, Ockham Drive, Greenford, London, UB6 0FD. Our VAT number is GB443822986. If you would like to contact us, you can do so by&nbsp;<u><a href=\"https://www.brompton.com/support/contact-us/email\" data-type=\"internal\">contacting us here</a></u>, or emailing us at&nbsp;<u><a href=\"mailto:support@brompton.co.uk\">support@hyperion.co.uk</a></u>. In these Terms we use &lsquo;<strong>hyperion</strong>&rsquo;, &lsquo;<strong>we</strong>&rsquo;, &lsquo;<strong>our</strong>&rsquo; and &lsquo;<strong>us</strong>&rsquo; to refer to hyperion Bicycle Retail Limited.</p>\r\n<p>&nbsp;</p>\r\n<h2>Making a Purchase</h2>\r\n<p>To purchase products from the Website, you must be 18 years of age or older and a resident of the United Kingdom. You must only purchase products for domestic and private use and not for any purposes associated with commercial or professional activities.&nbsp;</p>\r\n<p>To make a purchase simply browse through the products featured on the Website and click on the items that you wish to buy to add them to your shopping basket. Please note that all bicycles listed for sale on the Website are manufactured to UK legal and regulatory requirements and are intended for use in the UK only. If you intend to use a bicycle purchased from the Website in a territory other than the UK please ensure you comply with any local requirements, which may differ to those in the UK.&nbsp;</p>\r\n<p><a href=\"https://www.brompton.com/p/1157/brompton-magic-bean\">D</a>ue to the limited availability of our products, we restrict the number of bicycles you can purchase from the Website to two per customer and/or per delivery address in any six-month period. From time to time, we may place further restriction on the number of \'Special Edition\' products that you can purchase. Any such restrictions will be stated on the relevant product page. Any orders that exceed these limits will be cancelled and refunded.&nbsp;</p>\r\n<p>After you have finished shopping, click on &lsquo;Go to Checkout&rsquo;. You may then log in or check-out as a guest, before providing any additional details that we need to satisfy your order.&nbsp;</p>\r\n<p>Once your order has been received, we will issue you with an order confirmation email, which will contain your order number. This order number is supplied for reference purposes only and does not constitute our acceptance of your order.&nbsp;</p>\r\n<p>Your order is an offer by you to purchase the product(s) ordered from us. Our acceptance of your order will take place only when we dispatch the products that you ordered from us and our acceptance will only relate to the products dispatched and not any other products included in your order. We may refuse to accept or fulfil any order in our absolute discretion. If payment is taken before products are dispatched and the order is subsequently not accepted in full, the payment will be refunded for any elements of the order that are not accepted. Please note that refunds will not cover any fees that may be imposed by your bank or finance provider.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>Price and Payment</h2>\r\n<p>The price of our products and our delivery charges will be as quoted on our Website from time to time, except in the case of obvious error. All prices are displayed in Pounds Sterling inclusive of UK VAT where applicable.&nbsp;</p>\r\n<p>Our Website contains a large number of products and it is always possible that some of the products listed on the Website may be incorrectly priced. We will normally verify prices as part of our dispatch procedures so that where a product&rsquo;s correct price is less than the stated price, we will charge the lower amount when dispatching the product to you. If a product&rsquo;s correct price is higher than the price stated on the Website, we will either contact you for instructions before dispatching the product, or reject your order and notify you of such rejection. We are under no obligation to provide any product to you at an obviously incorrect price.&nbsp;</p>\r\n<p>Please note that all products that you order through the Website will remain the property of hyperion until we have dispatched them and received payment in full from you for those products.&nbsp;</p>\r\n<p>Payment may be made by debit or credit card, through finance or such other methods as listed on the Website when placing an order. For full information and terms of finance please click here. If for any reason any payment is refused after we have dispatched any product(s) we will have the right to request the payment from you or recover the relevant product(s). We may charge you for any costs incurred by us in recovering the product(s) or seeking further payment.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>Delivery of Products&nbsp;</h2>\r\n<p>Products featured on the Website may be available for delivery by click and collect and/or delivery direct to home. Please refer to the relevant product pages for details of which delivery option is available for your chosen product.&nbsp;</p>\r\n<p>The delivery times shown on the Website assume that a product is in stock. If we do not have a product that you ordered in stock, we will let you know as soon as possible and provide an estimated date on which the product will be dispatched. If you do not accept the revised dispatch date, you will be entitled to cancel your order and receive a refund.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>Delivery by Click and Collect&nbsp;</h2>\r\n<p>When selecting a product to purchase, you will be asked to select your preferred store for collection.&nbsp;</p>\r\n<p>Your chosen store will notify you directly once your product is ready to collect. Your product will be held for collection for 15 (fifteen) days. If you have not collected your product within this time, we will attempt to contact you for further instructions and may charge you for reasonable storage costs and (if applicable) any subsequent delivery costs. If, despite our reasonable efforts, we are unable to contact you or rearrange the collection or a delivery we will have the right (but not the obligation) to cancel your order and refund to you the price paid less any losses and/or reasonable costs that we have incurred in relation your failure to collect the product. Please note that you will be required to provide your order number and proof of identify upon collection.&nbsp;</p>\r\n<p>Once you have collected your product, risk in that product passes to you and you are responsible for its security.&nbsp;</p>\r\n<p><em><u><a href=\"https://www.brompton.com/support/delivery-and-returns\">For more information about click and collect please click here.&nbsp;</a></u></em></p>\r\n<p>&nbsp;</p>\r\n<h2>Delivery of Products Direct to Home</h2>\r\n<p>We only deliver products to addresses within the UK (excluding the Channel Islands).&nbsp;</p>\r\n<p>We are not able to deliver orders to mail forwarding, mail hotel or P.O. Box addresses.&nbsp;</p>\r\n<p>Delivery of products direct to home will be made to the delivery address supplied by you (provided this address complies with the conditions above) at the time of ordering, using the delivery method selected by you.&nbsp;</p>\r\n<p>Once we have delivered any product to you, risk in that product passes to you and you are responsible for its security.&nbsp;</p>\r\n<p>Please note that some components of our bicycles are removed for safety reasons prior to shipment and must be fitted by you when you receive your product direct to home. Written information on how to fit these components, along with the tools required, are included with your bicycle. Further information can be found here. If you have any questions or require any assistance with this,&nbsp;<u><a href=\"https://www.brompton.com/support/contact-us/email\">please contact our Customer Service Team through this webpage</a></u>.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>Your Right to Cancel an Order</h2>\r\n<p>At hyperion we want you to be completely satisfied every time you shop with us. If for any reason you change your mind and wish to return any non-custom product to us just let us know by contacting our Customer Service Team through this webpage or by completing the cancellation form accessed by clicking here. You must do this by no later than 14 days after the day on which you receive the relevant product. Once you have notified us that you wish to return a product, you must return that product to us in its original condition within 14 days. All products collected by you via Click and Collect must be returned to the store from where they were collected. All products delivered to you must be returned to our warehouse, details of which will be provided in the delivery paperwork which will be included with your product. You are responsible for the cost of returning the product to us. Please note that any product you return is your responsibility until it reaches our warehouse (for product delivered direct to home) or the store from where it was collected (for products delivered via click and collect). We therefore recommend that you send your product back to us using a delivery service that insures you for the value of the products. If you cancel an order and return a product as described above, we will issue a full refund for the price paid for the product in question plus any standard delivery cost (but not for any additional amount you may have paid for delivery over the standard delivery cost), and less any deduction which we may lawfully make for damage or other loss of value to the product resulting from excessive handling or use of the product prior to its return to us.&nbsp;</p>\r\n<p><strong>Please note&nbsp;</strong>that, unless faulty, products which have been custom made to your specification through the Build a hyperion function on the Website cannot be returned.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>28 Days Satisfaction Guarantee&nbsp;</h2>\r\n<p>hyperion is offering consumers the chance to try their hyperion for 28 days. Returns are accepted for all hyperion bicycles, subject to the Returns Criteria (set out in the paragraph below), and provided they have not been altered or modified in any manner. This offer is exclusively available to customers within the UK. Proof of purchase is required to process a return under this policy. &nbsp;&nbsp;</p>\r\n<p><u><strong>Returns Criteria</strong></u></p>\r\n<p>To be eligible for a return under the 28 Days Satisfaction Guarantee, a bicycle should not have any visible marks exceeding 2cm or any structural damage, to the frame or componentry, and must not differ from the original specification.&nbsp;</p>\r\n<p><u><strong>Return Process</strong></u></p>\r\n<p>The 28 day return period starts on the day your bike is delivered to you. &nbsp;Bicycles should be returned in their original packaging to ensure safety during transit. &nbsp;All products collected by you via Click and Collect may be returned to our warehouse, details of which will be provided by hyperion&rsquo;s Customer Service Team upon request to return a bicycle, or to the store in which the product was collected. &nbsp;All products delivered to you directly to your home must be returned to our warehouse details of which will be provided by hyperion&rsquo;s Customer Service Team upon request to return a bicycle. You are responsible for the cost of returning the product to us.&nbsp;</p>\r\n<p><u><strong>Refunds</strong></u></p>\r\n<p>A full refunds will be processed for returns meeting our Returns Criteria. In instances where a bicycle does meet the Returns Criteria, the refund will not be processed.&nbsp;</p>\r\n<p><u><strong>Offer Duration and Withdrawal</strong></u>&nbsp;</p>\r\n<p>This offer commences on 1 November 2023.We reserve the right to amend or withdraw this offer at any time.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>If There is a Problem with your Product&nbsp;</h2>\r\n<p>If you have any questions or complaints about your product,&nbsp;<u><a href=\"https://www.brompton.com/support/contact-us/email\">please contact our Customer Service Team through this webpage</a></u>.&nbsp;</p>\r\n<p>We are under a legal duty to supply products that are in conformity with these Terms, and are as described, fit for purpose and of satisfactory quality. Nothing in these Terms will affect your legal rights.&nbsp;</p>\r\n<p>In certain circumstances you will have a legal right to reject a faulty product. If you are entitled to reject a product and you wish to exercise that right, you must either return the product in person to the hyperion store where you collected it (if applicable), send it back to us, or (if it is not suitable for sending) allow us to collect it from you. We will pay the costs of postage or collection.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<h2>100-Mile Service</h2>\r\n<p>We encourage all our customers to seek a first service of their bicycles after 1 month or once they have done 100 miles (whichever comes first). Please contact your local authorised dealer for more information. For help finding your closest dealer please follow this link or&nbsp;<u><a href=\"https://www.brompton.com/support/contact-us/email\" data-type=\"internal\">contact our Customer Service Team through this webpage</a></u>.</p>\r\n<p>&nbsp;</p>\r\n<h2>Warranty</h2>\r\n<p>All bicycles purchased through the Website are covered by a 2-year unlimited mileage warranty for the main frame components, commencing from the date of sale. This can be extended to 7-years by registering your new bicycle on the My hyperion section of the Website. Other non-wearing parts on your bicycle (crank arms, brake calipers, mudguards, etc.) are covered by a 2-year warranty. Full terms and conditions of the warranty are available here.</p>\r\n<p>To make a claim under the warranty please contact your local authorised hyperion dealer. For help finding your closest dealer please&nbsp;<u><a data-type=\"unknown\">follow this link</a></u>&nbsp;or&nbsp;<u><a href=\"https://www.brompton.com/support/contact-us/email\">contact our Customer Service Team through this webpage</a></u>.</p>\r\n<p>&nbsp;</p>\r\n<h2>Prohibited uses of the Website</h2>\r\n<p>In using the Website, you are prohibited from:</p>\r\n<ul>\r\n<li>any unlawful use or any use inconsistent with these Terms including acting fraudulently or maliciously &ndash; for example, any hacking into or inserting malicious code, such as viruses, or harmful data, into the Website, any service or operating system;</li>\r\n<li>infringing our intellectual property rights or those of any third party in relation to your use of the Website;</li>\r\n<li>transmitting any material that is defamatory, offensive or otherwise objectionable in relation to your use of the Website;</li>\r\n<li>using the Website in a way that could damage, disable, overburden, impair or compromise our systems or security or interfere with other users; and</li>\r\n<li>collecting or harvesting any information or data from any Website or our systems or attempting to decipher any transmissions to or from the servers running any Website.</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<h2>Intellectual Property Rights</h2>\r\n<p>All intellectual property rights in the Website and any and all material published on or available via the Website (including but not limited to text, graphics, photos, logos, button icons, images, trade marks, audio and audio visual clips, databases, data compilations, documents, data and software) throughout the world belong to us (or our licensors) and the rights in the Website and any such material are licensed (not sold) to you subject to these Terms. You have no rights in, or to, the Website or the material published on or available via the Website other than the limited right of use in accordance with these Terms. For the avoidance of doubt you may not, without our prior written consent:</p>\r\n<ul>\r\n<li>copy, reproduce, use or otherwise deal with any content on the Website;</li>\r\n<li>modify, distribute or re-post any content on the Website for any purpose; or</li>\r\n<li>commercially exploit the content of the Website.</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<h2>Computer Viruses</h2>\r\n<p>We will use reasonable endeavours to ensure that no part of the Website will contain or spread any viruses or other malicious code. However, we recommend that you ensure that computers/devices used to access the Website run up-to-date anti-virus software as a precaution.</p>\r\n<p>&nbsp;</p>\r\n<h2>Our Liability to You</h2>\r\n<p>These Terms are not intended to, and shall not , limit or exclude any liability that we are not permitted to limit or exclude under applicable law, including our liability for personal injury or death caused by our negligence, for fraud or fraudulent misrepresentation, or for our breach of applicable consumer laws or your legal rights as a consumer.</p>\r\n<p>We are only responsible for losses that are a foreseeable consequence of our breach of these Terms. We will not be liable to you to the extent we are prevented or delayed from complying with our obligations under these Terms by anything you (or anyone acting on your behalf) do or fail to do or due to events which are beyond our reasonable control.</p>\r\n<p>We only supply products for domestic and private use. We will not be liable for any losses related to any business of yours including (without limitation) lost data, lost profits, lost revenues or business interruption.</p>\r\n<p>&nbsp;</p>\r\n<h2>Law and Jurisdiction</h2>\r\n<p>These Terms, and any dispute or claim arising out of or in connection with these terms and conditions of Terms and/or your use of the Website, shall be governed by English law and subject to the exclusive jurisdiction of the courts of England and Wales.</p>\r\n<p>&nbsp;</p>\r\n<h2>Third Party Rights</h2>\r\n<p>Only you and hyperion shall be entitled to enforce these Terms. No other person shall be entitled to enforce any of these Terms, whether by virtue of the Contracts (Rights of Third Parties) Act 1999 or otherwise. However, we may transfer our rights and obligations under these Terms to another organisation. We will always tell you in writing if this happens and will ensure that the transfer does not affect your rights under these Terms.</p>\r\n<p>&nbsp;</p>\r\n<h2>Ending your rights under these Terms</h2>\r\n<p>We may end your rights to use the Website if you break these Terms in a serious way. If you can put what you have done right, we may give you a reasonable opportunity to do so.</p>\r\n<p>If we end your rights to use the Website you must stop all activities authorised by these Terms, including your use of the Website.</p>\r\n<p>&nbsp;</p>\r\n<h2>Changes to these Terms</h2>\r\n<p>We reserve the right to change and update these Terms from time to time, in order to reflect changes in law or best practice, changes in our business practices, or to deal with additional features of functionalities which we may introduce to the Website or products available via the Website.</p>\r\n<p>We will notify you in advance of any material changes to these Terms via messaging on the Website. By continuing to use the Website after changes are notified and have come into effect, you are accepting those changes and will be bound by them. If you do not agree to any changes, you should immediately cease using the Website. However, the terms and conditions that apply to the contract for any purchase of our products shall be those that were in force at the time the contract was formed.</p>\r\n<h2>Klarna</h2>\r\n<p>In cooperation with&nbsp;<u><a href=\"https://www.klarna.com/uk/\">Klarna</a></u>&nbsp;Bank AB (publ), Sveav&auml;gen 46, 111 34 Stockholm, Sweden, we offer you the following payment options. Klarna offers Pay in 3 instalments, Pay in 30 days and Financing</p>\r\n<p>Klarna\'s Pay in 3 / Pay in 30 days are unregulated credit agreements. Borrowing more than you can afford or paying late may negatively impact your financial status and ability to obtain credit. 18+, UK residents only. Subject to status. Late fees may apply.&nbsp;<u><a href=\"https://www.klarna.com/uk/terms-and-conditions/\">Ts &amp; Cs apply</a>.</u></p>\r\n<p>Further information and Klarna&rsquo;s user terms you can find&nbsp;<u><a href=\"https://cdn.klarna.com/1.0/shared/content/legal/terms/0/en_gb/user\">here</a></u>. General information on Klarna can be found&nbsp;<u><a href=\"https://www.klarna.com/uk/\">here</a></u>. Your personal data is handled in accordance with applicable data protection law and in accordance with the information in&nbsp;<u><a href=\"https://cdn.klarna.com/1.0/shared/content/legal/terms/0/en_gb/privacy\">Klarna\'s privacy statement</a></u>.</p>\r\n<p>hyperion Bicycle Retail Limited, trading as hyperion and hyperion Junction London, is authorised and regulated by the Financial Conduct Authority (FCA FRN 999906) and acts as a credit intermediary and not a lender, offering credit products provided exclusively by Klarna Bank AB (publ). Please note that Pay in 3 instalments and Pay in 30 days agreements are not regulated by the FCA. Finance is only available to permanent UK residents aged 18+, subject to status, T&amp;Cs; apply,&nbsp;<u><a href=\"https://www.klarna.com/uk/terms-and-conditions/\">Klarna Terms and Conditions</a></u>. If you would like to know how we handle complaints, please ask for a copy of our complaints handling process. You can also find information about referring a complaint to the Financial Ombudsman Service (FOS) at&nbsp;<u><a href=\"https://www.financial-ombudsman.org.uk/\">financial-ombudsman.org.uk</a></u>.</p>\r\n<p>&nbsp;</p>\r\n<h2>Waste Electrical and Electronic Equipment (WEEE)</h2>\r\n<p>Waste Electrical and Electronic Equipment (WEEE) is regulated by the UK Government, and as part of our commitment to reducing the amount of unwanted electrical waste being incinerated or sent to landfill sites, we&rsquo;ll recycle your old electricals free of charge when you buy new ones.</p>\r\n<p>Electrical and electronic equipment is now the fastest growing waste stream in the UK and across the world. Recycling and reusing unwanted electrical or electronics can help save the planet, boost the economy, and improve lives. Electrical and electronic equipment (EEE) contains materials, parts and substances which can be dangerous to the environment and harmful to human health if not disposed of correctly.</p>\r\n<p>Anything with a plug, battery or cable can be recycled or reused. You&rsquo;ll find a crossed-out wheelie bin symbol on all your electrical items as a reminder to recycle your old electricals.</p>\r\n<p>If you have bought a new item or want to dispose of old electrical equipment, for many people the easiest option is to drop off your old equipment at a recycling site local to you. You can find local recycling points for your old electricals here -&nbsp;<u><a href=\"https://www.recycleyourelectricals.org.uk/electrical-recycling-near-me/\">https://www.recycleyourelectricals.org.uk/electrical-recycling-near-me/</a></u></p>\r\n<p>If you are buying a new electrical or electronic item from us, we\'ll recycle the one you&rsquo;re replacing for free. Simply bring the old electrical item into our store within 28 days, show us the receipt for its replacement and we&rsquo;ll do the rest.</p>\r\n<p>&nbsp;</p>', b'1', 'Website Terms of Use and Sale', 'd6eivanupn7omjpjgvx3', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731472327/d6eivanupn7omjpjgvx3.webp', 'Term of use', NULL, 4, 1),
(4, '2024-11-13 15:52:28.000000', '2024-11-13 11:34:42.000000', '<p><strong>DELIVERY</strong></p>\r\n<p>We deliver to anywhere within the UK excluding the Channel Islands and Isle of Man. We don\'t deliver to forwarding addresses.<br><br><strong>When will my order be sent out?</strong></p>\r\n<p>Our team process and send your order in 2 working days.<br><br><strong>How do I track my order?</strong></p>\r\n<p>Once your order leaves the factory, you will be notified via email and provided with the tracking number as well as a unique delivery code which will need to be presented to the courier to receive your order.</p>\r\n<p><strong>Delivery costs</strong><br><br>Free delivery on all orders over &pound;50. &pound;4.95 delivery fee for any order under &pound;50.<br><br><strong>CLICK &amp; COLLECT</strong></p>\r\n<p>Click &amp; Collect orders will be dispatched within 2 working days. Once your order arrives to the selected dealer, the bike will go through a process of inspection. The dealer will contact you directly as soon as your bike is ready for collection. If you would like to have more information regarding the collection date, please contact the dealer directly.</p>\r\n<p>Please note that Click &amp; Collect bikes can only be picked up at the collection dealer you select during checkout.</p>\r\n<p>To find your nearest Click &amp; Collect stores,&nbsp;<u><a data-type=\"unknown\">click here</a></u>.&nbsp;</p>\r\n<p><img class=\"page-hero__desktop-img desktop-only\" src=\"https://cdn.bfldr.com/XM1XF37H/at/tb8xf638crnrs5fcxr46pf/Returns_1920x805.jpg?auto=webp&amp;width=1138&amp;height=477&amp;format=jpg\" alt=\"A man with a Brompton Explore\" width=\"1000\" data-v-f28e6efe=\"\"></p>\r\n<p><strong>RETURNS</strong><br><br>We want you to be happy every time you shop with us. If for some reason you have bought something and changed your mind, we will reimburse the value of the items (but not the shipping costs).</p>\r\n<p><strong>Bikes:&nbsp;</strong>We accept used returns of bikes as part of our 28 day satisfaction guarantee, for full details&nbsp;<u><a href=\"https://www.brompton.com/legal/terms-of-use\" data-type=\"internal\">please refer to our T&amp;Cs</a></u>.<br>&nbsp;<br><strong>Clothing, Parts and Accessories:</strong>&nbsp;We only accept returns on unused items in the original packaging within 28 days of delivery.</p>\r\n<p>All unwanted items will need to be returned at your own expense unless specified otherwise by the customer service team.&nbsp;</p>\r\n<p><strong>To kickstart your return</strong></p>\r\n<ul>\r\n<li>\r\n<p>Submit your Online&nbsp;Returns Form (at the bottom of this page)&nbsp;within 28&nbsp;days of the item being delivered.</p>\r\n</li>\r\n<li>\r\n<p>Make sure your return parcel is postmarked within 28 days of submitting your form.&nbsp;</p>\r\n</li>\r\n</ul>\r\n<p><br><strong>Getting your refund</strong></p>\r\n<p>Your return shipment may take up to 5 business days to reach our warehouse, plus processing time.&nbsp; Once we have your items checked in and processed, we\'ll send the refund to your original payment method.&nbsp;</p>\r\n<p><strong>Exchanges&nbsp;</strong></p>\r\n<p>Simply return the original for a refund and place a new order.&nbsp;</p>\r\n<p><strong>Damaged items</strong></p>\r\n<p>If your product has a manufacturing defect or was damaged during transit, fill out&nbsp;the Online Returns Form (at the bottom of this page). And we\'ll take it from there, including reimbursing any shipping costs.&nbsp;</p>\r\n<p><u><a href=\"https://www.brompton.com/support/knowledge/how-long-is-my-warranty\" data-type=\"internal\">Read our warranty policy here</a></u>.<br>&nbsp;</p>\r\n<p><strong>Bought something Brompton from another store or website?</strong><br><br>Get in touch with them directly for their returns information.&nbsp;</p>', b'1', 'Delivery and returns', 'euraxet9szdwr0g9n7c1', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731472482/euraxet9szdwr0g9n7c1.jpg', 'Delivery and returns', '2024-11-13 11:40:24.000000', 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog_categories`
--

CREATE TABLE `blog_categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `blog_categories`
--

INSERT INTO `blog_categories` (`id`, `name`) VALUES
(1, 'About Us'),
(4, 'Legal'),
(2, 'News'),
(3, 'Support');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invalid_token`
--

CREATE TABLE `invalid_token` (
  `token_id` varchar(255) NOT NULL,
  `expiry_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `invalid_token`
--

INSERT INTO `invalid_token` (`token_id`, `expiry_time`) VALUES
('0565de42-1a0c-4af7-b6e1-028220980d2e', '2024-11-13 11:58:48.000000'),
('0c338056-2cbe-4937-ad87-1746396953bc', '2024-11-13 12:04:21.000000'),
('1e320e3a-8849-442d-90ab-223acf92bc30', '2024-11-12 16:35:03.000000'),
('238e65db-53bb-41b7-94ce-d89f22f0f824', '2024-11-11 22:14:08.000000'),
('251c8ea0-34e2-46b0-80bb-79d6c5dfa78f', '2024-11-11 22:08:11.000000'),
('31af9088-feb5-4bfd-a277-43e5a4960f2c', '2024-11-11 23:05:11.000000'),
('3422172e-c5a6-4780-8385-784f45ee0f54', '2024-11-11 22:23:54.000000'),
('38a96def-5811-4559-ae10-194197283452', '2024-11-11 22:09:25.000000'),
('40e6f51a-9019-4eec-835b-379115b9dbd6', '2024-11-09 23:13:30.000000'),
('474e3ebc-0921-4242-8372-cd7e38317aa8', '2024-11-11 22:08:29.000000'),
('4c3e9212-77a4-42d2-aa32-598c73425439', '2024-11-11 22:12:52.000000'),
('576795b1-1dc0-47f7-a8b7-7ecf22774239', '2024-11-11 22:19:36.000000'),
('6396e1a9-9b99-4616-96e5-fa02da03307a', '2024-11-11 22:54:40.000000'),
('6932484f-0fcd-43fa-bbfc-933cb46d3513', '2024-11-11 22:13:28.000000'),
('7463c068-cce8-459b-8ef1-ebc2f30a9c8a', '2024-11-11 22:11:05.000000'),
('8487ad95-8125-4317-a53f-08e006d96a9b', '2024-11-11 22:56:42.000000'),
('95f3da82-db1b-4ef6-9a0b-fa6b01994aa2', '2024-11-11 22:17:59.000000'),
('af341523-0c59-4c88-bfd3-06dd25e5e214', '2024-11-11 22:18:47.000000'),
('b28230db-06c6-4fb3-a4c8-e3779f1d05f9', '2024-11-13 12:14:32.000000'),
('bf5bb206-7776-42b4-b005-dd252eebae7a', '2024-11-11 22:21:05.000000'),
('c74acf4f-d0f6-4a96-844e-72e4ded8ad1b', '2024-11-11 21:56:13.000000'),
('db47e9a9-edf3-4741-bc41-5cf0e928c658', '2024-11-11 22:20:39.000000'),
('de802e2a-d53a-4845-b96a-5436d27d7abc', '2024-11-11 22:07:26.000000'),
('e8048476-86a3-4fe2-9624-35e34ebd55d8', '2024-11-11 22:56:55.000000'),
('edbb2059-0cf6-4872-a3f7-6a52f2949e3a', '2024-11-13 11:25:44.000000'),
('f409d11f-77d6-4008-aa14-28f0773316fd', '2024-11-11 22:24:24.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notification`
--

CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `notification_status` enum('NEW','READ') DEFAULT NULL,
  `order_status` enum('AWAITING_PAYMENT','CONFIRMED','DENIED','PENDING','REFUNDED') DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `notification`
--

INSERT INTO `notification` (`id`, `created_at`, `notification_status`, `order_status`, `order_id`) VALUES
(1, '2024-11-11 14:09:32.000000', 'READ', 'PENDING', 22),
(2, '2024-11-11 14:19:23.000000', 'READ', 'PENDING', 23),
(3, '2024-11-11 14:21:03.000000', 'READ', 'CONFIRMED', 23),
(4, '2024-11-11 14:21:14.000000', 'READ', 'DENIED', 23),
(5, '2024-11-11 14:21:57.000000', 'READ', 'AWAITING_PAYMENT', 24),
(6, '2024-11-11 14:33:01.000000', 'READ', 'DENIED', 24),
(7, '2024-11-11 14:33:16.000000', 'READ', 'CONFIRMED', 24),
(8, '2024-11-11 14:35:28.000000', 'READ', 'CONFIRMED', 24),
(9, '2024-11-11 14:35:38.000000', 'READ', 'DENIED', 24),
(10, '2024-11-11 14:47:23.000000', 'READ', 'DENIED', 24),
(11, '2024-11-11 15:10:28.000000', 'READ', 'CONFIRMED', 22),
(12, '2024-11-11 15:23:11.000000', 'READ', 'DENIED', 24),
(13, '2024-11-11 15:23:38.000000', 'READ', 'DENIED', 24),
(14, '2024-11-11 15:25:08.000000', 'READ', 'DENIED', 24),
(15, '2024-11-11 15:26:05.000000', 'READ', 'DENIED', 24),
(16, '2024-11-11 15:28:33.000000', 'READ', 'DENIED', 24),
(17, '2024-11-11 15:29:22.000000', 'READ', 'DENIED', 24),
(18, '2024-11-11 15:32:13.000000', 'READ', 'DENIED', 24),
(19, '2024-11-11 15:32:46.000000', 'READ', 'DENIED', 24),
(20, '2024-11-11 15:33:14.000000', 'READ', 'DENIED', 24),
(21, '2024-11-11 15:34:08.000000', 'READ', 'DENIED', 24),
(22, '2024-11-11 15:34:31.000000', 'READ', 'DENIED', 24),
(23, '2024-11-11 15:35:22.000000', 'READ', 'DENIED', 24),
(24, '2024-11-11 15:35:45.000000', 'READ', 'DENIED', 24),
(25, '2024-11-11 15:38:18.000000', 'READ', 'DENIED', 24),
(26, '2024-11-11 22:29:04.000000', 'READ', 'CONFIRMED', 24),
(27, '2024-11-13 13:22:01.000000', 'NEW', 'AWAITING_PAYMENT', 25),
(28, '2024-11-13 13:25:18.000000', 'NEW', 'AWAITING_PAYMENT', 26),
(29, '2024-11-13 13:25:33.000000', 'NEW', 'AWAITING_PAYMENT', 27),
(30, '2024-11-13 13:26:38.000000', 'NEW', 'AWAITING_PAYMENT', 28),
(31, '2024-11-13 13:27:54.000000', 'NEW', 'AWAITING_PAYMENT', 29),
(32, '2024-11-13 13:29:46.000000', 'NEW', 'AWAITING_PAYMENT', 30),
(33, '2024-11-13 13:30:36.000000', 'NEW', 'AWAITING_PAYMENT', 31),
(34, '2024-11-13 13:32:20.000000', 'NEW', 'AWAITING_PAYMENT', 32),
(35, '2024-11-13 13:36:38.000000', 'NEW', 'AWAITING_PAYMENT', 33),
(36, '2024-11-13 13:38:32.000000', 'NEW', 'AWAITING_PAYMENT', 34),
(37, '2024-11-13 13:39:11.000000', 'NEW', 'AWAITING_PAYMENT', 35),
(38, '2024-11-13 13:43:09.000000', 'NEW', 'AWAITING_PAYMENT', 36),
(39, '2024-11-13 13:45:01.000000', 'NEW', 'AWAITING_PAYMENT', 37),
(40, '2024-11-13 13:47:28.000000', 'NEW', 'AWAITING_PAYMENT', 38),
(41, '2024-11-13 13:48:52.000000', 'NEW', 'AWAITING_PAYMENT', 39),
(42, '2024-11-13 13:49:20.000000', 'READ', 'PENDING', 39),
(43, '2024-11-13 13:49:56.000000', 'NEW', 'CONFIRMED', 39),
(44, '2024-11-13 13:51:22.000000', 'NEW', 'PENDING', 40),
(45, '2024-11-13 14:00:37.000000', 'NEW', 'PENDING', 41),
(46, '2024-11-13 14:35:49.000000', 'NEW', 'DENIED', 41),
(47, '2024-11-13 14:36:00.000000', 'NEW', 'DENIED', 40),
(48, '2024-11-13 15:26:53.000000', 'NEW', 'PENDING', 42),
(49, '2024-11-13 15:45:25.000000', 'NEW', 'PENDING', 43);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notification_roles`
--

CREATE TABLE `notification_roles` (
  `notification_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `notification_roles`
--

INSERT INTO `notification_roles` (`notification_id`, `role_id`) VALUES
(1, 5),
(1, 6),
(1, 7),
(2, 5),
(2, 6),
(2, 7),
(3, 5),
(3, 6),
(3, 7),
(4, 5),
(4, 6),
(4, 7),
(5, 5),
(5, 6),
(5, 7),
(6, 5),
(6, 6),
(6, 7),
(7, 5),
(7, 6),
(7, 7),
(8, 5),
(8, 6),
(8, 7),
(9, 5),
(9, 6),
(9, 7),
(10, 5),
(10, 6),
(10, 7),
(11, 5),
(11, 6),
(11, 7),
(12, 5),
(12, 6),
(12, 7),
(13, 5),
(13, 6),
(13, 7),
(14, 5),
(14, 6),
(14, 7),
(15, 5),
(15, 6),
(15, 7),
(16, 5),
(16, 6),
(16, 7),
(17, 5),
(17, 6),
(17, 7),
(18, 5),
(18, 6),
(18, 7),
(19, 5),
(19, 6),
(19, 7),
(20, 5),
(20, 6),
(20, 7),
(21, 5),
(21, 6),
(21, 7),
(22, 5),
(22, 6),
(22, 7),
(23, 5),
(23, 6),
(23, 7),
(24, 5),
(24, 6),
(24, 7),
(25, 5),
(25, 6),
(25, 7),
(26, 5),
(26, 6),
(26, 7),
(27, 5),
(27, 6),
(27, 7),
(28, 5),
(28, 6),
(28, 7),
(29, 5),
(29, 6),
(29, 7),
(30, 5),
(30, 6),
(30, 7),
(31, 5),
(31, 6),
(31, 7),
(32, 5),
(32, 6),
(32, 7),
(33, 5),
(33, 6),
(33, 7),
(34, 5),
(34, 6),
(34, 7),
(35, 5),
(35, 6),
(35, 7),
(36, 5),
(36, 6),
(36, 7),
(37, 5),
(37, 6),
(37, 7),
(38, 5),
(38, 6),
(38, 7),
(39, 5),
(39, 6),
(39, 7),
(40, 5),
(40, 6),
(40, 7),
(41, 5),
(41, 6),
(41, 7),
(42, 5),
(42, 6),
(42, 7),
(43, 5),
(43, 6),
(43, 7),
(44, 5),
(44, 6),
(44, 7),
(45, 5),
(45, 6),
(45, 7),
(46, 5),
(46, 6),
(46, 7),
(47, 5),
(47, 6),
(47, 7),
(48, 5),
(48, 6),
(48, 7),
(49, 5),
(49, 6),
(49, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `payment_method_id` bigint(20) DEFAULT NULL,
  `status` enum('PENDING','CONFIRMED','DENIED','AWAITING_PAYMENT','REFUNDED') DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `address`, `customer_name`, `email`, `note`, `phone_number`, `payment_method_id`, `status`, `created_at`) VALUES
(1, '123 Main Street, Cityville', 'John Doe', 'johndoe@example.com', 'This is a test note.', '1234567890', 1, 'PENDING', NULL),
(2, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 1, 'CONFIRMED', '2024-11-08 21:27:56.000000'),
(3, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 1, 'PENDING', '2024-11-08 21:29:40.000000'),
(5, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 12:26:14.000000'),
(8, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 1, 'PENDING', '2024-11-09 12:52:15.000000'),
(9, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 12:52:33.000000'),
(10, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 12:52:50.000000'),
(11, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 12:53:35.000000'),
(12, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 12:56:46.000000'),
(13, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-09 14:29:22.000000'),
(14, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'CONFIRMED', '2024-11-09 14:31:29.000000'),
(15, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'DENIED', '2024-11-09 14:41:48.000000'),
(16, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'CONFIRMED', '2024-11-09 15:03:26.000000'),
(17, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'DENIED', '2024-11-09 15:25:50.000000'),
(18, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'CONFIRMED', '2024-11-09 15:29:35.000000'),
(19, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-10 22:16:49.000000'),
(20, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-11 08:52:17.000000'),
(21, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-11 14:07:39.000000'),
(22, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 1, 'CONFIRMED', '2024-11-11 14:09:31.000000'),
(23, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 1, 'DENIED', '2024-11-11 14:19:21.000000'),
(24, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'CONFIRMED', '2024-11-11 14:21:57.000000'),
(25, '123 Main Street, Cityville', 'John Doe', 'zxczxcbb1239@gmail.com', 'This is a test note.', '1234567890', 2, 'AWAITING_PAYMENT', '2024-11-13 13:22:00.000000'),
(26, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:25:18.000000'),
(27, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:25:33.000000'),
(28, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:26:38.000000'),
(29, 'áda', 'minh', 'zxczxcbb1239@gmail.com', '234234', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:27:54.000000'),
(30, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123123', '13123123', 2, 'AWAITING_PAYMENT', '2024-11-13 13:29:45.000000'),
(31, '3sd213a2s', '123123', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:30:36.000000'),
(32, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:32:19.000000'),
(33, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:36:38.000000'),
(34, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:38:32.000000'),
(35, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:39:11.000000'),
(36, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '1232', 'áda', 2, 'AWAITING_PAYMENT', '2024-11-13 13:43:09.000000'),
(37, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:45:01.000000'),
(38, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '2312312', '0123456789', 2, 'AWAITING_PAYMENT', '2024-11-13 13:47:28.000000'),
(39, '13123', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 2, 'CONFIRMED', '2024-11-13 13:48:52.000000'),
(40, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 1, 'DENIED', '2024-11-13 13:51:22.000000'),
(41, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 1, 'DENIED', '2024-11-13 14:00:37.000000'),
(42, '3sd213a2s', 'd1a3sd135as1d', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 1, 'PENDING', '2024-11-13 15:26:53.000000'),
(43, '3sd213a2s', 'minh', 'zxczxcbb1239@gmail.com', '123123', '0123456789', 1, 'PENDING', '2024-11-13 15:45:24.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_detail_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`id`, `amount`, `order_id`, `product_detail_id`) VALUES
(25, 1, 25, 5),
(26, 4, 26, 5),
(27, 4, 27, 5),
(28, 4, 28, 5),
(29, 4, 29, 5),
(30, 4, 30, 5),
(31, 4, 31, 5),
(32, 4, 32, 5),
(33, 4, 33, 5),
(34, 4, 34, 5),
(35, 4, 35, 5),
(36, 4, 36, 5),
(37, 4, 37, 5),
(38, 4, 38, 5),
(39, 4, 39, 5),
(40, 1, 40, 5),
(41, 1, 41, 5),
(42, 1, 42, 5),
(43, 1, 43, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment_method`
--

CREATE TABLE `payment_method` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `fontawesome_logo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `payment_method`
--

INSERT INTO `payment_method` (`id`, `name`, `fontawesome_logo`) VALUES
(1, 'Cash', '<i class=\"fa-solid fa-money-bill-1-wave\"></i>'),
(2, 'Paypal', '<i class=\"fa-brands fa-paypal\"></i>');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `permissions`
--

CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `permissions`
--

INSERT INTO `permissions` (`id`, `description`, `permission_name`) VALUES
(1, 'create blog', 'CREATE_BLOG'),
(2, 'read blog', 'READ_BLOG'),
(3, 'update blog', 'UPDATE_BLOG'),
(4, 'delete blog', 'DELETE_BLOG'),
(5, 'create product', 'CREATE_PRODUCT'),
(6, 'read product', 'READ_PRODUCT'),
(7, 'update product', 'UPDATE_PRODUCT'),
(8, 'delete product', 'DELETE_PRODUCT'),
(9, 'create product detail', 'CREATE_PRODUCT_DETAIL'),
(10, 'read product detail', 'READ_PRODUCT_DETAIL'),
(11, 'update product detail', 'UPDATE_PRODUCT_DETAIL'),
(12, 'delete product detail', 'DELETE_PRODUCT_DETAIL'),
(13, 'create blog category', 'CREATE_BLOG_CATEGORY'),
(14, 'read blog category', 'READ_BLOG_CATEGORY'),
(15, 'update blog category', 'UPDATE_BLOG_CATEGORY'),
(16, 'delete blog category', 'DELETE_BLOG_CATEGORY'),
(17, 'create product category', 'CREATE_PRODUCT_CATEGORY'),
(18, 'read product category', 'READ_PRODUCT_CATEGORY'),
(19, 'update product category', 'UPDATE_PRODUCT_CATEGORY'),
(20, 'delete product category', 'DELETE_PRODUCT_CATEGORY'),
(21, 'create product sub category', 'CREATE_PRODUCT_SUB_CATEGORY'),
(22, 'read product sub category', 'READ_PRODUCT_SUB_CATEGORY'),
(23, 'update product sub category', 'UPDATE_PRODUCT_SUB_CATEGORY'),
(24, 'delete product sub category', 'DELETE_PRODUCT_SUB_CATEGORY'),
(25, 'create order', 'CREATE_ORDER'),
(26, 'read bill', 'READ_BILL'),
(27, 'update bill', 'UPDATE_BILL'),
(28, 'delete bill', 'DELETE_BILL'),
(29, 'create orders', 'CREATE_ORDERS'),
(30, 'read orders', 'READ_ORDERS'),
(31, 'update orders', 'UPDATE_ORDERS'),
(32, 'delete orders', 'DELETE_ORDERS'),
(33, 'create order detail', 'CREATE_ORDER_DETAIL'),
(34, 'read order detail', 'READ_ORDER_DETAIL'),
(35, 'update order detail', 'UPDATE_ORDER_DETAIL'),
(36, 'delete order detail', 'DELETE_ORDER_DETAIL'),
(37, 'create notification', 'CREATE_NOTIFICATION'),
(38, 'read notification', 'READ_NOTIFICATION'),
(39, 'update notification', 'UPDATE_NOTIFICATION'),
(40, 'delete notification', 'DELETE_NOTIFICATION'),
(41, 'create user', 'CREATE_USER'),
(42, 'read user', 'READ_USER'),
(43, 'update user', 'UPDATE_USER'),
(44, 'delete user', 'DELETE_USER'),
(45, 'confirm order', 'CONFIRM_ORDER'),
(46, 'deny order', 'DENY_ORDER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `thumbnail_public_id` varchar(255) DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `product_sub_category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `created_at`, `description`, `is_active`, `name`, `price`, `thumbnail_public_id`, `thumbnail_url`, `updated_at`, `weight`, `product_sub_category_id`) VALUES
(1, '2024-11-08 13:16:43.000000', '<p style=\"text-align: center;\"><em><strong>A line hể boiss</strong></em></p>', b'1', 'A line 8', 123, 'ip3frs551hnaxqgrqoeh', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731046606/ip3frs551hnaxqgrqoeh.jpg', NULL, 123123, 1),
(2, '2024-11-12 16:45:17.000000', '<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">\r\n<p>&nbsp;</p>\r\n<img class=\"checkerboard__image\" style=\"float: right;\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bgjbtmphth8vp677xnmxx7bg/G_Line_fit_guide_1200x800.jpg?format=jpg&amp;width=1000&amp;height=667\" alt=\"G Line size chart\" width=\"398\" height=\"265\" loading=\"lazy\" data-v-1277f382=\"\"></div>\r\n<h2 class=\"checkerboard__heading\" style=\"text-align: center;\" data-v-1277f382=\"\">G Line sizes</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" style=\"text-align: center;\" data-v-1277f382=\"\">\r\n<p>G Line comes in three easy-to-choose sizes based on your height. Small, medium or large. The single-size frame has varying stem and seatpost heights, developed and tested with a world-leading&nbsp;</p>\r\n</div>\r\n<p style=\"text-align: center;\">bike fit expert for the&nbsp;best ride experience.</p>\r\n<p style=\"text-align: center;\">For more information on how to choose, watch our useful&nbsp;<u>video guide</u>.</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p><img class=\"checkerboard__image\" style=\"float: left;\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bw9p9btj3tqw5v7q9nfqjrj/G-Line-Checker-3.jpg?auto=webp\" alt=\"G Line\" width=\"437\" height=\"228\" loading=\"lazy\" data-v-1277f382=\"\">&nbsp;</p>\r\n<h2 class=\"checkerboard__heading\" style=\"text-align: center;\" data-v-1277f382=\"\">Big on ride feel, compact in size</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" style=\"text-align: center;\" data-v-1277f382=\"\">We created G Line to be the best one-bike solution for the city and beyond, and then we made it a Brompton. The frame geometry is comparable to a full size bike, yet it transforms into a compact package that stores and travels easily. So you can go anywhere.</div>', b'0', 'G Line with Roller Frame - 8 Speed', 2499, 'bnxncfblrvppoziuhqui', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731404718/bnxncfblrvppoziuhqui.jpg', '2024-11-12 17:26:13.000000', 14, 2),
(3, '2024-11-13 10:44:29.000000', '<div id=\"b2b95c07-ce5e-4ad3-aa09-387e81b0ee4b\" class=\"content-block tall-image-title-tiles tall-image-title-tiles--light\" data-v-a8057a7e=\"\" data-gtm-vis-first-on-screen100622466_315=\"1643946\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div class=\"tall-image-title-tiles__inner\" data-v-a8057a7e=\"\">\r\n<div class=\"tall-image-title-tiles__text-content\" data-v-a8057a7e=\"\">\r\n<h2 class=\"tall-image-title-tiles__heading\" style=\"text-align: center;\" data-v-a8057a7e=\"\">Features</h2>\r\n<div class=\"tall-image-title-tiles__copy br-rte\" style=\"text-align: center;\" data-v-a8057a7e=\"\">Expertly engineered to go where others can&rsquo;t. G Line is the first ever Brompton with the ride feel of a full-size bike. Brand-new geometry, 20&rdquo; wheels, game-changing comfort and capability. All holistically designed around the fold that made us famous. It\'s your one-bike solution to the city and beyond.</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__desktop-tile-wrapper desktop-only\" style=\"text-align: center;\" data-v-a8057a7e=\"\">\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/xrstsj482xnkrsrgvcx3jc59/G_Line_Highlights_2.jpg?auto=webp\" alt=\"G Line. The most versatile bike in the world\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">The most versatile bike in the world</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">Expertly engineered to go where others can&rsquo;t. G Line is the first ever Brompton with the ride feel of a full-size bike.</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/8535nfn8k58tw9nzcsgp86n4/20_inch_wheels.jpg?auto=webp\" alt=\"20&rdquo; wheels\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">20&rdquo; wheels</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">\r\n<p>Big enough for any adventure yet compact enough to fit inside the fold. The G Line&rsquo;s solidly built 20&rdquo; wheelset comes equipped with custom-made puncture-resistant tyres.</p>\r\n</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/3nm6qrwjq66rnzjzc7vmj9vz/Brakes-Feature-G-Line.jpg?auto=webp\" alt=\"Hydraulic disc brakes\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">Hydraulic disc brakes</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">\r\n<p>Super dependable stopping power. The first ever Brompton to come equipped with disc brakes for all terrain, all-weather riding.</p>\r\n</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/qtc6f4rsvqpqjn63k5mnqr7/Wide_platform_pedals.jpg?auto=webp\" alt=\"wide platform pedals\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">Wide platform pedals</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">\r\n<p>The grippiest, most comfortable Brompton pedal set. The left hand pedal can be released with a quick squeeze and pull to make your folded bike even more compact.&nbsp;</p>\r\n</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/hbgh8r7kr9x3mjvpj3pc67r/Wide_handlebars.jpg?auto=webp\" alt=\"\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">Wide handlebars</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">\r\n<p>Stay in control. With the custom made handlebars, G Line gives you exceptional stability &ndash; from leverage on uphills and rough ground to comfort on longer rides.</p>\r\n</div>\r\n</div>\r\n<div class=\"tall-image-title-tiles__tile\" data-v-a8057a7e=\"\">\r\n<div data-v-a8057a7e=\"\"><img class=\"tall-image-title-tiles__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bhwf4nw4j7rqb3gx5k8txnj/ergonomic_grips.jpg?auto=webp\" alt=\"ergonomic grips\" loading=\"lazy\" data-v-a8057a7e=\"\"></div>\r\n<h5 class=\"tall-image-title-tiles__title\" data-v-a8057a7e=\"\">Ergonomic grips</h5>\r\n<div class=\"tall-image-title-tiles__text br-rte\" data-v-a8057a7e=\"\">\r\n<p>Every touchpoint between you and the bike is designed with comfort and control in mind.</p>\r\n</div>\r\n</div>\r\n</div>\r\n</div>\r\n</div>\r\n<div id=\"36ec6c8e-8978-4d9e-9d28-cb26e88cc4a7\" class=\"content-block\" style=\"text-align: center;\" data-gtm-vis-first-on-screen100622466_315=\"1647622\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div data-v-f28e6efe=\"\">\r\n<div class=\"page-hero\" data-v-f28e6efe=\"\"><img class=\"page-hero__desktop-img desktop-only\" src=\"https://cdn.bfldr.com/XM1XF37H/at/87kvw8r87fgc7wp3h69r7379/G-Line-Desktop-Graphic.jpg?auto=webp\" alt=\"Bike with text\" width=\"966\" height=\"405\" data-v-f28e6efe=\"\">\r\n<div class=\"page-hero__content\" data-v-f28e6efe=\"\">\r\n<div class=\"page-hero__content-inner\" data-v-f28e6efe=\"\">\r\n<div class=\"page-hero__controls\" data-v-f28e6efe=\"\">&nbsp;</div>\r\n</div>\r\n</div>\r\n</div>\r\n</div>\r\n</div>\r\n<div id=\"dc3c1b90-4f58-4702-a9d1-0b4d609e569e\" class=\"content-block\" style=\"text-align: center;\" data-gtm-vis-first-on-screen100622466_315=\"1650349\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div class=\"checkerboard checkerboard--light\" data-v-1277f382=\"\">\r\n<div class=\"checkerboard__text-content\" data-v-1277f382=\"\">\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\">G Line sizes</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">\r\n<p>G Line comes in three easy-to-choose sizes based on your height. Small, medium or large. The single-size frame has varying stem and seatpost heights, developed and tested with a world-leading bike fit expert for the best ride experience.</p>\r\n<p>For more information on how to choose, watch our useful&nbsp;<u>video guide</u>.</p>\r\n</div>\r\n</div>\r\n<div class=\"checkerboard__image-wrapper\" data-v-1277f382=\"\"><img class=\"checkerboard__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bgjbtmphth8vp677xnmxx7bg/G_Line_fit_guide_1200x800.jpg?format=jpg&amp;width=1000&amp;height=667\" alt=\"G Line size chart\" loading=\"lazy\" data-v-1277f382=\"\"></div>\r\n</div>\r\n</div>\r\n<div id=\"ef8e7898-2d11-415d-bb46-5ede625e8393\" class=\"content-block\" style=\"text-align: center;\" data-gtm-vis-first-on-screen100622466_315=\"1831540\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div class=\"checkerboard checkerboard--light checkerboard--right-align\" data-v-1277f382=\"\">\r\n<div class=\"checkerboard__text-content\" data-v-1277f382=\"\">\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\">Big on ride feel, compact in size</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">We created G Line to be the best one-bike solution for the city and beyond, and then we made it a Brompton. The frame geometry is comparable to a full size bike, yet it transforms into a compact package that stores and travels easily. So you can go anywhere.</div>\r\n</div>\r\n<div class=\"checkerboard__image-wrapper\" data-v-1277f382=\"\"><img class=\"checkerboard__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bw9p9btj3tqw5v7q9nfqjrj/G-Line-Checker-3.jpg?auto=webp\" alt=\"G Line\" loading=\"lazy\" data-v-1277f382=\"\"></div>\r\n</div>\r\n</div>\r\n<div id=\"4704c60e-d311-45c1-bf15-d2f8723e72ca\" class=\"content-block\" style=\"text-align: center;\" data-gtm-vis-first-on-screen100622466_315=\"1943073\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div class=\"checkerboard checkerboard--light\" data-v-1277f382=\"\">\r\n<div class=\"checkerboard__text-content\" data-v-1277f382=\"\">\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\">The most capable Brompton ever</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">Rigorously tested over 250,000 km, first to meet industry standards, then to meet ours, G Line goes where others can&rsquo;t. Now, you can confidently tackle everything from dusty singletrack to rain-soaked cobbles. This bike does it all with ease.</div>\r\n</div>\r\n<div class=\"checkerboard__image-wrapper\" data-v-1277f382=\"\"><img class=\"checkerboard__image\" src=\"https://cdn.bfldr.com/XM1XF37H/at/5nvkhb2hfw7889c4v34ktgv7/G-Line-Checker-4.jpg?auto=webp\" alt=\"G Line\" loading=\"lazy\" data-v-1277f382=\"\"></div>\r\n</div>\r\n</div>\r\n<div id=\"fccbcce7-135d-4507-9bbe-fca80b508206\" class=\"content-block\" data-gtm-vis-first-on-screen100622466_315=\"2168419\" data-gtm-vis-total-visible-time100622466_315=\"500\" data-gtm-vis-has-fired100622466_315=\"1\">\r\n<div class=\"checkerboard checkerboard--light checkerboard--right-align\" data-v-1277f382=\"\">\r\n<div class=\"checkerboard__text-content\" style=\"text-align: center;\" data-v-1277f382=\"\">\r\n<h2 class=\"checkerboard__heading\" data-v-1277f382=\"\">Game-changing comfort</h2>\r\n<div class=\"checkerboard__marketing-text br-rte\" data-v-1277f382=\"\">Nothing feels like G Line &ndash; the entirely new frame, all-new 20&rdquo; wheels, our widest ever handlebars and tyres. Everything is thoughtfully engineered to give the balanced feel of a mountain bike and all-day comfort that&rsquo;s nothing short of joyous. You&rsquo;ll feel the difference on every ride.</div>\r\n</div>\r\n<div class=\"checkerboard__image-wrapper\" data-v-1277f382=\"\"><img class=\"checkerboard__image\" style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://cdn.bfldr.com/XM1XF37H/at/bbx4j7p5swjhwf9hh447tg/G_Line_PDP_Checker_3.jpg?auto=webp\" alt=\"G Line\" loading=\"lazy\" data-v-1277f382=\"\"></div>\r\n</div>\r\n</div>', b'1', 'G Line with Roller Frame - 8 Speed', 2499, 'xolp7albvw9tbtsozbpf', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731469475/xolp7albvw9tbtsozbpf.jpg', NULL, 14, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_categories`
--

CREATE TABLE `product_categories` (
  `id` bigint(20) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_categories`
--

INSERT INTO `product_categories` (`id`, `is_active`, `name`) VALUES
(1, b'1', 'Bikes'),
(2, b'1', 'Parts'),
(3, b'1', 'Luggage'),
(4, b'1', 'Apparel'),
(5, b'1', 'Accessories');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_color`
--

CREATE TABLE `product_color` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_color`
--

INSERT INTO `product_color` (`id`, `color`) VALUES
(32, 'red'),
(33, 'orange'),
(34, 'gold'),
(35, 'yellow'),
(36, 'lime'),
(37, 'green'),
(38, 'aqua'),
(39, 'cyan'),
(40, 'teal'),
(41, 'blue'),
(42, 'navy'),
(43, 'purple'),
(44, 'magenta'),
(45, 'pink'),
(46, 'brown'),
(47, 'maroon'),
(48, 'chocolate'),
(49, 'coral'),
(50, 'salmon'),
(51, 'khaki'),
(52, 'olive'),
(53, 'gray'),
(54, 'black'),
(55, 'white'),
(56, 'silver');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_details`
--

CREATE TABLE `product_details` (
  `id` bigint(20) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `color_id` bigint(20) NOT NULL,
  `handlebar_id` bigint(20) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_details`
--

INSERT INTO `product_details` (`id`, `is_active`, `stock`, `product_id`, `color_id`, `handlebar_id`, `material_id`) VALUES
(5, b'1', 1, 3, 33, 2, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_handlebars`
--

CREATE TABLE `product_handlebars` (
  `id` bigint(20) NOT NULL,
  `style` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_handlebars`
--

INSERT INTO `product_handlebars` (`id`, `style`) VALUES
(1, 'low'),
(2, 'mid'),
(3, 'high');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_images`
--

CREATE TABLE `product_images` (
  `id` bigint(20) NOT NULL,
  `public_id` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_detail_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_images`
--

INSERT INTO `product_images` (`id`, `public_id`, `url`, `product_detail_id`) VALUES
(18, 'yfgl0egqmwtzywyfylxc', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731469516/yfgl0egqmwtzywyfylxc.jpg', 5),
(19, 'x5kkmadobf0u6njwdpof', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731469517/x5kkmadobf0u6njwdpof.jpg', 5),
(20, 'vv3wuewfc3mzqqey0p1h', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731469519/vv3wuewfc3mzqqey0p1h.jpg', 5),
(21, 'bvkrpoqspb1lvrybuwnn', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731469521/bvkrpoqspb1lvrybuwnn.jpg', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_materials`
--

CREATE TABLE `product_materials` (
  `id` bigint(20) NOT NULL,
  `material` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_materials`
--

INSERT INTO `product_materials` (`id`, `material`) VALUES
(1, 'wood'),
(2, 'steel'),
(3, 'titanium'),
(4, 'bone'),
(5, 'vibranium'),
(6, 'plastic');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(5, 'ADMIN'),
(6, 'MODERATOR'),
(7, 'SALE'),
(8, 'WRITER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role_permissions`
--

CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role_permissions`
--

INSERT INTO `role_permissions` (`role_id`, `permission_id`) VALUES
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(5, 5),
(5, 6),
(5, 7),
(5, 8),
(5, 9),
(5, 10),
(5, 11),
(5, 12),
(5, 13),
(5, 14),
(5, 15),
(5, 16),
(5, 17),
(5, 18),
(5, 19),
(5, 20),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(5, 25),
(5, 26),
(5, 27),
(5, 28),
(5, 29),
(5, 30),
(5, 31),
(5, 32),
(5, 33),
(5, 34),
(5, 35),
(5, 36),
(5, 37),
(5, 38),
(5, 39),
(5, 40),
(5, 41),
(5, 42),
(5, 43),
(5, 44),
(5, 45),
(5, 46),
(6, 2),
(6, 3),
(6, 4),
(6, 6),
(6, 7),
(6, 8),
(6, 10),
(6, 11),
(6, 12),
(6, 14),
(6, 15),
(6, 16),
(6, 18),
(6, 19),
(6, 20),
(6, 22),
(6, 23),
(6, 24),
(6, 26),
(6, 27),
(6, 28),
(6, 30),
(6, 31),
(6, 32),
(6, 34),
(6, 35),
(6, 36),
(6, 38),
(6, 39),
(6, 40),
(6, 42),
(6, 43),
(6, 44),
(7, 2),
(7, 6),
(7, 10),
(7, 14),
(7, 18),
(7, 22),
(7, 26),
(7, 30),
(7, 34),
(7, 38),
(7, 42),
(7, 45),
(7, 46),
(8, 1),
(8, 2),
(8, 3),
(8, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sub_product_categories`
--

CREATE TABLE `sub_product_categories` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `thumbnail_public_id` varchar(255) DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `product_category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sub_product_categories`
--

INSERT INTO `sub_product_categories` (`id`, `description`, `is_active`, `name`, `thumbnail_public_id`, `thumbnail_url`, `product_category_id`) VALUES
(1, '<p>A line</p>', b'0', 'A line', 'btwp9bjgn5gxiqujwkhy', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731046553/btwp9bjgn5gxiqujwkhy.png', 1),
(2, '<p>G Line. The most versatile bike in the world. Expertly engineered to go where others can&rsquo;t. G Line is the first ever Brompton with the ride feel of a full-size bike.</p>', b'1', 'G Line', 'qmfoh8kuf4cdbnolfehf', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731402432/qmfoh8kuf4cdbnolfehf.jpg', 1),
(3, '<p>Reliable and ever-ready, the A Line features the one-of-a kind Brompton fold &ndash; there when you need it, hidden away when you don&rsquo;t.</p>', b'1', 'A Line', 'eyyre9ytzyks5yfyd7yp', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731402485/eyyre9ytzyks5yfyd7yp.jpg', 1),
(4, '<p>Reliable, comfortable steel frame, robust equipment, all in a compact folding design. Made to unlock your city, and the world. Nothing folds like a Brompton.</p>', b'1', 'C Line', 'zs7fcqgf3wsrbamm0dk1', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731402532/zs7fcqgf3wsrbamm0dk1.jpg', 1),
(5, '<p>P Line takes the classic Brompton design &ndash; innovative, compact, portable &ndash; which has endured for nearly five decades, and gives you even more.</p>', b'1', 'P Line', 'pqgezdcupsxc8aicrpp1', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731402604/pqgezdcupsxc8aicrpp1.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `thumbnail_public_id` varchar(255) DEFAULT NULL,
  `image-url` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `email`, `full_name`, `is_active`, `password`, `phone`, `thumbnail_public_id`, `image-url`, `username`) VALUES
(1, 'minhbvht@gmail.com', 'minh', b'0', '$2a$10$joPQX2lFOpcO/CUXe5U0PuUCp5zKb2QCTwQP0v4LS9D/YNWyVP3dy', '0123456789', 'bynquaxmjv3luwoubsjk', 'http://res.cloudinary.com/dt6ukgxqc/image/upload/v1731046469/bynquaxmjv3luwoubsjk.jpg', '12312qw');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 5),
(1, 6),
(1, 7),
(1, 8);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK81mhk2ue4gcjgtsu3ks65gnrp` (`blog_category_id`),
  ADD KEY `FKpg4damav6db6a6fh5peylcni5` (`user_id`);

--
-- Chỉ mục cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKh31sqw6uih12w9ef074k6mxfw` (`name`);

--
-- Chỉ mục cho bảng `invalid_token`
--
ALTER TABLE `invalid_token`
  ADD PRIMARY KEY (`token_id`);

--
-- Chỉ mục cho bảng `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8ec3mroggermua3g3dsm618ad` (`order_id`);

--
-- Chỉ mục cho bảng `notification_roles`
--
ALTER TABLE `notification_roles`
  ADD PRIMARY KEY (`notification_id`,`role_id`),
  ADD KEY `FKpcel5i3r4wbx6ty4cfkkovaxs` (`role_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgeqwl6x0iadp9e2459uh3o8fv` (`payment_method_id`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8epq58a2bo3u2pr369m3ydr0o` (`product_detail_id`),
  ADD KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`);

--
-- Chỉ mục cho bảng `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKnry1f3jmc4abb5yvkftlvn6vg` (`permission_name`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKomm3jaggduhyvcgf196he3g9g` (`product_sub_category_id`);

--
-- Chỉ mục cho bảng `product_categories`
--
ALTER TABLE `product_categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product_color`
--
ALTER TABLE `product_color`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnfvvq3meg4ha3u1bju9k4is3r` (`product_id`),
  ADD KEY `FKfta0kc9j9kpdxg0eg7griqfx5` (`color_id`),
  ADD KEY `FK9p86pdt9wut79bm0n52wxrp15` (`handlebar_id`),
  ADD KEY `FK1dhhixjnawputuoeaue1s74wr` (`material_id`);

--
-- Chỉ mục cho bảng `product_handlebars`
--
ALTER TABLE `product_handlebars`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm4gxbfwixn66eng24198t54rh` (`product_detail_id`);

--
-- Chỉ mục cho bảng `product_materials`
--
ALTER TABLE `product_materials`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK716hgxp60ym1lifrdgp67xt5k` (`role_name`);

--
-- Chỉ mục cho bảng `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD PRIMARY KEY (`role_id`,`permission_id`),
  ADD KEY `FKegdk29eiy7mdtefy5c7eirr6e` (`permission_id`);

--
-- Chỉ mục cho bảng `sub_product_categories`
--
ALTER TABLE `sub_product_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKky6mf8l8m6o7mkgve78i9p5j8` (`product_category_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- Chỉ mục cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blogs`
--
ALTER TABLE `blogs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `blog_categories`
--
ALTER TABLE `blog_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `notification`
--
ALTER TABLE `notification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `permissions`
--
ALTER TABLE `permissions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `product_categories`
--
ALTER TABLE `product_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `product_color`
--
ALTER TABLE `product_color`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT cho bảng `product_details`
--
ALTER TABLE `product_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `product_handlebars`
--
ALTER TABLE `product_handlebars`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `product_images`
--
ALTER TABLE `product_images`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `product_materials`
--
ALTER TABLE `product_materials`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `sub_product_categories`
--
ALTER TABLE `sub_product_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `FK81mhk2ue4gcjgtsu3ks65gnrp` FOREIGN KEY (`blog_category_id`) REFERENCES `blog_categories` (`id`),
  ADD CONSTRAINT `FKpg4damav6db6a6fh5peylcni5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FK8ec3mroggermua3g3dsm618ad` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `notification_roles`
--
ALTER TABLE `notification_roles`
  ADD CONSTRAINT `FKg6agma7gk5w3qlw9igklklu4p` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`id`),
  ADD CONSTRAINT `FKpcel5i3r4wbx6ty4cfkkovaxs` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKgeqwl6x0iadp9e2459uh3o8fv` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK8epq58a2bo3u2pr369m3ydr0o` FOREIGN KEY (`product_detail_id`) REFERENCES `product_details` (`id`),
  ADD CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKomm3jaggduhyvcgf196he3g9g` FOREIGN KEY (`product_sub_category_id`) REFERENCES `sub_product_categories` (`id`);

--
-- Các ràng buộc cho bảng `product_details`
--
ALTER TABLE `product_details`
  ADD CONSTRAINT `FK1dhhixjnawputuoeaue1s74wr` FOREIGN KEY (`material_id`) REFERENCES `product_materials` (`id`),
  ADD CONSTRAINT `FK9p86pdt9wut79bm0n52wxrp15` FOREIGN KEY (`handlebar_id`) REFERENCES `product_handlebars` (`id`),
  ADD CONSTRAINT `FKfta0kc9j9kpdxg0eg7griqfx5` FOREIGN KEY (`color_id`) REFERENCES `product_color` (`id`),
  ADD CONSTRAINT `FKnfvvq3meg4ha3u1bju9k4is3r` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `FKm4gxbfwixn66eng24198t54rh` FOREIGN KEY (`product_detail_id`) REFERENCES `product_details` (`id`);

--
-- Các ràng buộc cho bảng `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD CONSTRAINT `FKegdk29eiy7mdtefy5c7eirr6e` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
  ADD CONSTRAINT `FKn5fotdgk8d1xvo8nav9uv3muc` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Các ràng buộc cho bảng `sub_product_categories`
--
ALTER TABLE `sub_product_categories`
  ADD CONSTRAINT `FKky6mf8l8m6o7mkgve78i9p5j8` FOREIGN KEY (`product_category_id`) REFERENCES `product_categories` (`id`);

--
-- Các ràng buộc cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
