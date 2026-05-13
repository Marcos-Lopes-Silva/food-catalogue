<script lang="ts">
	let apiStatus = $state<string | null>(null);

	async function pingApi() {
		const res = await fetch('/api/health');
		const data = await res.json();
		apiStatus = data.status;
	}
</script>

<svelte:head>
	<title>Food Catalogue</title>
</svelte:head>

<main>
	<h1>Food Catalogue</h1>
	<button onclick={pingApi}>Ping API</button>
	{#if apiStatus}
		<p>API: {apiStatus}</p>
	{/if}
</main>
