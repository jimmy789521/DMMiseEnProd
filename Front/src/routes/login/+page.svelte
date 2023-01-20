<script>
  import { onMount } from "svelte";

/**
     * @type {any[]}
     */
let users = [];
let name = ""
let password = ""
let admin = false
/**
   * @type {string | null}
   */
let result = null
/* GET EXAMPLE
onMount(async () => {
  const res = await fetch(`http://localhost:8080/api/public/user`);
   users = await res.json();
});*/

async function login () {
  const res = await fetch('http://localhost:8080/api/public/user', {
    method: 'POST',
    headers: {'Content-Type' : 'application/json'},
    body: JSON.stringify({
      name,
      password,
      admin
    })
  })

  const json = await res.json()
  result = JSON.stringify(json)
}

</script>

<h1> Page test login</h1>

<form>
    <input name="username" type="username" placeholder="Nom d'utilisateur" bind:value={name}>
    <input name="password" type="password" placeholder="Mot de passe" bind:value={password}>
    <input name="admin" type="checkbox" id="checkAdmin" bind:value={admin}>
    <button type="button" on:click={login}>Log in</button>
  </form>

  <p>
    Result :
  </p>
  <pre>
    {result}
  </pre>
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