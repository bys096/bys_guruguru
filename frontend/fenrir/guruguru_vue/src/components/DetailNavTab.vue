<template>
  <!-- nav for tab -->
  <div class="border-bottom border-top bg-white border-1 sticky-top">
    <div class="container p-0 px-md-3">
      <ul class="
            nav
            d-md-flex
            justify-content-between justify-content-md-start
            fs-lg-6 fs-mobile-5
          " role="tablist" aria-orientation="vertical">
        <li class="nav-item">
          <a class="nav-link link-dark py-3 active" data-bs-toggle="pill" href="#tab-comment" role="tab" aria-controls="tab-comment" aria-selected="true" >レビュー</a>
        </li>
        <li class="nav-item">
          <a class="nav-link link-dark py-3" data-bs-toggle="pill" href="#tab-news" role="tab" aria-controls="tab-news" aria-selected="false" >よくある質問</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>

</style>