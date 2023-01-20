<script>
  import { onMount } from "svelte";

/**
     * @type {any[]}
     */
let users = [];

onMount(async () => {
  const res = await fetch(`http://localhost:8080/api/users`);
   users = await res.json();
});

</script>

<h1> Page test login</h1>

<form method="POST">
    <input name="username" type="username" placeholder="Nom d'utilisateur">
    <input name="password" type="password" placeholder="Mot de passe">
    <button>Log in</button>
  </form>

  <div>
    <h1>Users List</h1>
    {#each users as user}
      <ul>
         <li>{user.name}</li>
     </ul>
   {:else}
     <!-- this block renders when users.length === 0 -->
      <p>loading...</p>
   {/each}
</div>