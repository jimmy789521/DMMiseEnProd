<script>
	import { page } from '$app/stores';
	import { onMount } from "svelte";

	// Show mobile icon and display menu
	let showMobileMenu = false;

// List of navigation items
const navItems = [
  { label: "Apprendre", href: "." },
  { label: "Inscription", href: "." },
  { label: "Forum", href: "." },
  { label: "Compte", href: "." }
];

// Mobile menu click event handler
const handleMobileIconClick = () => (showMobileMenu = !showMobileMenu);

// Media match query handler
const mediaQueryHandler = e => {
  // Reset mobile state
  if (!e.matches) {
	showMobileMenu = false;
  }
};

// Attach media query listener on mount hook
onMount(() => {
  const mediaListener = window.matchMedia("(max-width: 767px)");

  mediaListener.addListener(mediaQueryHandler);
});
  
  let isDropdownOpen = false // default state (dropdown close)

const handleDropdownClick = () => {
  isDropdownOpen = !isDropdownOpen // togle state on click
}

const handleDropdownFocusLoss = ({ relatedTarget, currentTarget }) => {
  // use "focusout" event to ensure that we can close the dropdown when clicking outside or when we leave the dropdown with the "Tab" button
  if (relatedTarget instanceof HTMLElement && currentTarget.contains(relatedTarget)) return // check if the new focus target doesn't present in the dropdown tree (exclude ul\li padding area because relatedTarget, in this case, will be null) 
  isDropdownOpen = false
}
</script>

<header>
	<nav>
		<div class="inner">
		  <!-- svelte-ignore a11y-click-events-have-key-events -->
		  <div on:click={handleMobileIconClick} class={`mobile-icon${showMobileMenu ? ' active' : ''}`}>
			<div class="middle-line"></div>
		  </div>
		  <ul class={`navbar-list${showMobileMenu ? ' mobile' : ''}`}>
			{#each navItems as item}
					  {#if item.label==="Apprendre"}
							  <div class="dropdown" on:focusout={handleDropdownFocusLoss}>
								  <button class={`apprendrebtn ${showMobileMenu ? ' mobile' : ''}`} on:click={handleDropdownClick} >
									  Apprendre
									  {#if isDropdownOpen}
						<svg
											  xmlns="http://www.w3.org/2000/svg"
											  fill="none"
											  viewBox="0 0 24 24"
											  class="inline-block h-6 w-6 stroke-current">
											  <title>Close Dropdown</title>
											  <path
												  stroke-linecap="round"
												  stroke-linejoin="round"
												  stroke-width="2"
												  d="M6 18L18 6M6 6l12 12" />
										  </svg>
									  {:else}
										  <svg
											  xmlns="http://www.w3.org/2000/svg"
											  fill="none"
											  viewBox="0 0 24 24"
											  class="inline-block h-6 w-6 stroke-current">
											  <title>Open Dropdown</title>
											  <path
											  stroke-linecap="round"
											  stroke-linejoin="round"
											  stroke-width="2"
						  d="M4,10h24c1.104,0,2-0.896,2-2s-0.896-2-2-2H4C2.896,6,2,6.896,2,8S2.896,10,4,10z M28,14H4c-1.104,0-2,0.896-2,2  s0.896,2,2,2h24c1.104,0,2-0.896,2-2S29.104,14,28,14z M28,22H4c-1.104,0-2,0.896-2,2s0.896,2,2,2h24c1.104,0,2-0.896,2-2  S29.104,22,28,22z"/>
										  </svg>
									  {/if}
								  </button>
								  <ul class="dropdown-content menu p-2 shadow bg-base-100 rounded-box w-52" style:visibility={isDropdownOpen ? 'visible' : 'hidden'}>
									  <li><a class="apprendrebtnsub" href=".">Tests</a></li>
									  <li><a class="apprendrebtnsub" href=".">Cours</a></li>
								  </ul>
							  </div>
					  {:else}
				  <li>
						<a href={item.href}>{item.label}</a>
				  </li>
					  {/if}
			{/each}
		  </ul>
		</div>
	  </nav>
</header>

<style>
	nav {
    background-color: rgba(0, 0, 0, 0.8);
    font-family: "Helvetica Neue", "Helvetica", "Arial", sans-serif;
    height: 45px;
    /* position: fixed;
    top: 0px;
    left: 0px;
    width: 100%; */
  }

  .inner {
    max-width: 980px;
    padding-left: 20px;
    padding-right: 20px;
    margin: auto;
    box-sizing: border-box;
    align-items: center;
    height: 100%;
  }

  .mobile-icon {
    width: 25px;
    height: 14px;
    position: relative;
    cursor: pointer;
  }

  .mobile-icon:after,
  .mobile-icon:before,
  .middle-line {
    content: "";
    position: absolute;
    width: 100%;
    height: 2px;
    background-color: #fff;
    transition: all 0.4s;
    transform-origin: center;
  }

  .mobile-icon:before,
  .middle-line {
    top: 0;
  }

  .mobile-icon:after,
  .middle-line {
    bottom: 0;
  }

  .mobile-icon:before {
    width: 66%;
  }

  .mobile-icon:after {
    width: 33%;
  }

  .middle-line {
    margin: auto;
  }

  .mobile-icon:hover:before,
  .mobile-icon:hover:after,
  .mobile-icon.active:before,
  .mobile-icon.active:after,
  .mobile-icon.active .middle-line {
    width: 100%;
  }

  .mobile-icon.active:before,
  .mobile-icon.active:after {
    top: 50%;
    transform: rotate(-45deg);
  }

  .mobile-icon.active .middle-line {
    transform: rotate(45deg);
  }

  .navbar-list {
    display: none;
    width: 100%;
    justify-content: space-between;
    margin: 0;
    padding: 0 40px;
  }

  .navbar-list.mobile {
    background-color: rgba(0, 0, 0, 0.8);
    position: fixed;
    display: block;
    height: calc(100% - 45px);
    bottom: 0;
    left: 0;
  }

  .navbar-list li {
    list-style-type: none;
    position: relative;
  }

  .navbar-list li:before {
    content: "";
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1px;
    background-color: #424245;
  }

  .navbar-list a {
    /* float: left;
	text-align: center; */
    color: #f2f2f2;
    text-decoration: none;
	  display: flex;
	  height: 45px;
	  align-items: center;
    padding: 0px 10px;
    font-size: 17px;
  }
	
	.apprendrebtn{
		border: none;
		color: #f2f2f2;;
    height: 45px;
    align-items: center;
    padding: 10px 10px;
    text-decoration: none;
    font-size: 17px;
	}

  .apprendrebtn.mobile{
		border: none;
		color: #f2f2f2;
    padding: 10px 10px;
    align-items: center;
    text-decoration: none;
    font-size: 17px;
    height: 45px;
	}

  .apprendrebtnsub{
    color: #f2f2f2 ;
    background-color: #424245;
    font-size: 17px;
    text-decoration: none;
  }

  @media only screen and (min-width: 767px) {
    .mobile-icon {
      display: none;
    }

    .navbar-list {
      display: flex;
      padding: 0;
    }

    .navbar-list a {
      display: inline-flex;
    }
  }
</style>
